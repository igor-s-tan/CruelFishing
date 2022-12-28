package com.igorstan.cruelfishing.entity;

import java.lang.reflect.Field;
import java.util.*;
import javax.annotation.Nonnull;
import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.entity.fish.FleshratFishEntity;
import com.igorstan.cruelfishing.init.CruelEntities;
import com.igorstan.cruelfishing.item.FiberglassFishingRodItem;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.network.NetworkHooks;

public class FiberglassFishingBobberEntity extends FishingBobberEntity {
    private final Random random = new Random();
    private boolean field_234597_c_;
    private int field_234598_d_;
    private static final Field HAS_LEFT_OWNER = ObfuscationReflectionHelper
            .findField(ProjectileEntity.class, "field_234611_d_");
    private static final DataParameter<Integer> DATA_HOOKED_ENTITY = EntityDataManager.createKey(FiberglassFishingBobberEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> DATA_CATCHING = EntityDataManager.createKey(FiberglassFishingBobberEntity.class, DataSerializers.BOOLEAN);
    private int ticksInGround;
    private int ticksCatchable;
    private int ticksCaughtDelay;
    private int ticksCatchableDelay;
    private float fishApproachAngle;
    private boolean canCatch = true;
    private boolean catching;
    private int catchTimer;
    private Entity caughtEntity;
    private FiberglassFishingBobberEntity.State currentState = FiberglassFishingBobberEntity.State.FLYING;
    private final int luck;
    private final int lureSpeed;

    @OnlyIn(Dist.CLIENT)
    public FiberglassFishingBobberEntity(World worldIn) {
        super(worldIn, Minecraft.getInstance().player, 0, 0, 0);
        this.luck = 0;
        this.lureSpeed = 0;
    }

    public FiberglassFishingBobberEntity(PlayerEntity p_i50220_1_, World p_i50220_2_, int p_i50220_3_, int p_i50220_4_) {
        super(p_i50220_1_, p_i50220_2_, p_i50220_3_, p_i50220_4_);
        this.luck = Math.max(0, p_i50220_3_);
        this.lureSpeed = Math.max(0, p_i50220_4_);

    }

    @Override
    protected void registerData() {
        this.getDataManager().register(DATA_HOOKED_ENTITY, 0);
        this.getDataManager().register(DATA_CATCHING, false);
    }

    @Override
    public void notifyDataManagerChange(@Nonnull DataParameter<?> key) {
        if (DATA_HOOKED_ENTITY.equals(key)) {
            int i = this.getDataManager().get(DATA_HOOKED_ENTITY);
            this.caughtEntity = i > 0 ? this.world.getEntityByID(i - 1) : null;
        }

        if (DATA_CATCHING.equals(key)) {
            this.field_234597_c_ = this.getDataManager().get(DATA_CATCHING);
            if (this.field_234597_c_) {
                this.setMotion(this.getMotion().x, (double)(-0.4F * MathHelper.nextFloat(this.random, 0.6F, 1.0F)), this.getMotion().z);
            }
        }

        super.notifyDataManagerChange(key);
    }


    private boolean func_234615_h_() {
        Entity entity = this.func_234616_v_();

        if (entity != null) {

            for (Entity entity1 : this.world.getEntitiesInAABBexcluding(this,
                    this.getBoundingBox().expand(this.getMotion()).grow(1.0D),
                    (p_234613_0_) -> !p_234613_0_.isSpectator() && p_234613_0_.canBeCollidedWith())) {
                if (entity1.getLowestRidingEntity() == entity.getLowestRidingEntity()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void tick() {
        this.random.setSeed(this.getUniqueID().getLeastSignificantBits() ^ this.world.getGameTime());

        try {
            boolean hasLeftOwner = HAS_LEFT_OWNER.getBoolean(this);

            if (!hasLeftOwner) {
                HAS_LEFT_OWNER.setBoolean(this, this.func_234615_h_());
            }
        } catch (IllegalAccessException e) {
            CruelFishingMod.LOGGER.error(e.getStackTrace());
        }

        if (!this.world.isRemote) {
            this.setFlag(6, this.isGlowing());
        }
        this.baseTick();
        PlayerEntity playerentity = this.func_234606_i_();

        if (playerentity == null) {
            this.remove();
        } else if (this.world.isRemote || !this.shouldStopFishing(playerentity)) {

            if (this.onGround) {
                ++this.ticksInGround;

                if (this.ticksInGround >= 1200) {
                    this.remove();
                    return;
                }
            } else {
                this.ticksInGround = 0;
            }
            float f = 0.0F;
            BlockPos blockpos = this.getPosition();
            FluidState fluidstate = this.world.getFluidState(blockpos);

            if (fluidstate.isTagged(FluidTags.LAVA) || fluidstate.isTagged(FluidTags.WATER)) {
                f = fluidstate.getActualHeight(this.world, blockpos);
            }
            boolean flag = f > 0.0F;

            if (this.currentState == State.FLYING) {

                if (this.caughtEntity != null) {
                    this.setMotion(Vector3d.ZERO);
                    this.currentState = State.HOOKED_IN_ENTITY;
                    return;
                }

                if (flag) {
                    this.setMotion(this.getMotion().mul(0.3D, 0.2D, 0.3D));
                    this.currentState = State.BOBBING;
                    return;
                }
                this.checkCollision();
            } else {

                if (this.currentState == State.HOOKED_IN_ENTITY) {

                    if (this.caughtEntity != null) {

                        if (!this.caughtEntity.isAlive()) {
                            this.caughtEntity = null;
                            this.currentState = State.FLYING;
                        } else {
                            this.setPosition(this.caughtEntity.getPosX(), this.caughtEntity.getPosYHeight(0.8D),
                                    this.caughtEntity.getPosZ());
                        }
                    }

                    return;
                }

                if (this.currentState == State.BOBBING) {
                    Vector3d vector3d = this.getMotion();
                    double d0 = this.getPosY() + vector3d.y - (double) blockpos.getY() - (double) f;

                    if (Math.abs(d0) < 0.01D) {
                        d0 += Math.signum(d0) * 0.1D;
                    }
                    this.setMotion(vector3d.x * 0.9D, vector3d.y - d0 * (double) this.rand.nextFloat() * 0.2D,
                            vector3d.z * 0.9D);
                    if (this.ticksCatchable <= 0 && this.ticksCatchableDelay <= 0) {
                        this.canCatch = true;
                    } else {
                        this.canCatch = this.canCatch && this.catchTimer < 10 && this.canFish(blockpos);
                    }

                    if (flag) {
                        this.catchTimer = Math.max(0, this.catchTimer - 1);

                        if (this.catching) {
                            this.setMotion(this.getMotion().add(0.0D,
                                    -0.1D * (double) this.random.nextFloat() * (double) this.random.nextFloat(),
                                    0.0D));
                        }

                        if (!this.world.isRemote) {
                            this.catchingFish(blockpos);
                        }
                    } else {
                        this.catchTimer = Math.min(10, this.catchTimer + 1);
                    }
                }
            }

            if (!fluidstate.isTagged(FluidTags.WATER) && !fluidstate.isTagged(FluidTags.LAVA)) {
                this.setMotion(this.getMotion().add(0.0D, -0.03D, 0.0D));
            }
            this.move(MoverType.SELF, this.getMotion());
            this.func_234617_x_();

            if (this.currentState == State.FLYING && (this.onGround || this.collidedHorizontally)) {
                this.setMotion(Vector3d.ZERO);
            }
            double d1 = 0.92D;
            this.setMotion(this.getMotion().scale(d1));
            this.recenterBoundingBox();
        }
    }

    private boolean shouldStopFishing(PlayerEntity p_234600_1_) {
        ItemStack itemstack = p_234600_1_.getHeldItemMainhand();
        ItemStack itemstack1 = p_234600_1_.getHeldItemOffhand();
        boolean flag = itemstack.getItem() instanceof FiberglassFishingRodItem;
        boolean flag1 = itemstack1.getItem() instanceof FiberglassFishingRodItem;
        if (!p_234600_1_.removed && p_234600_1_.isAlive() && (flag || flag1) && !(this.getDistanceSq(p_234600_1_) > 1024.0D)) {
            return false;
        } else {
            this.remove();
            return true;
        }
    }

    @Override
    @Nonnull
    public EntityType<?> getType() {
        return CruelEntities.FIBERGLASS_BOBBER;
    }

    private void checkCollision() {
        RayTraceResult raytraceresult = ProjectileHelper.func_234618_a_(this, this::func_230298_a_);
        this.onImpact(raytraceresult);
    }



    @Override
    protected void onEntityHit(@Nonnull EntityRayTraceResult p_213868_1_) {
        if (!this.world.isRemote) {
            this.caughtEntity = p_213868_1_.getEntity();
            this.setHookedEntity();
        }

    }

    private void setHookedEntity() {
        this.getDataManager().set(DATA_HOOKED_ENTITY, this.caughtEntity.getEntityId() + 1);
    }

    private void catchingFish(BlockPos p_190621_1_) {
        ServerWorld serverworld = (ServerWorld)this.world;
        int i = 1;
        BlockPos blockpos = p_190621_1_.up();
        if (this.rand.nextFloat() < 0.25F && this.world.isRainingAt(blockpos)) {
            ++i;
        }

        if (this.rand.nextFloat() < 0.5F && !this.world.canSeeSky(blockpos)) {
            --i;
        }

        if (this.ticksCatchable > 0) {
            --this.ticksCatchable;
            if (this.ticksCatchable <= 0) {
                this.ticksCaughtDelay = 0;
                this.ticksCatchableDelay = 0;
                this.getDataManager().set(DATA_CATCHING, false);
            }
        } else if (this.ticksCatchableDelay > 0) {
            this.ticksCatchableDelay -= i;
            if (this.ticksCatchableDelay > 0) {
                this.fishApproachAngle = (float)((double)this.fishApproachAngle + this.rand.nextGaussian() * 4.0D);
                float f = this.fishApproachAngle * ((float)Math.PI / 180F);
                float f1 = MathHelper.sin(f);
                float f2 = MathHelper.cos(f);
                double d0 = this.getPosX() + (double)(f1 * (float)this.ticksCatchableDelay * 0.1F);
                double d1 = (double)((float)MathHelper.floor(this.getPosY()) + 1.0F);
                double d2 = this.getPosZ() + (double)(f2 * (float)this.ticksCatchableDelay * 0.1F);
                BlockState blockstate = serverworld.getBlockState(new BlockPos(d0, d1 - 1.0D, d2));
                if (serverworld.getBlockState(new BlockPos((int)d0, (int)d1 - 1, (int)d2)).getMaterial() == net.minecraft.block.material.Material.WATER) {
                    if (this.rand.nextFloat() < 0.15F) {
                        serverworld.spawnParticle(ParticleTypes.BUBBLE, d0,     d1 - (double)0.1F, d2, 1, (double)f1, 0.1D, (double)f2, 0.0D);
                    }

                    float f3 = f1 * 0.04F;
                    float f4 = f2 * 0.04F;
                    serverworld.spawnParticle(ParticleTypes.FISHING, d0, d1, d2, 0, (double)f4, 0.01D, (double)(-f3), 1.0D);
                    serverworld.spawnParticle(ParticleTypes.FISHING, d0, d1, d2, 0, (double)(-f4), 0.01D, (double)f3, 1.0D);
                }
            } else {
                this.playSound(SoundEvents.ENTITY_FISHING_BOBBER_SPLASH, 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                double d3 = this.getPosY() + 0.5D;
                serverworld.spawnParticle(ParticleTypes.BUBBLE, this.getPosX(), d3, this.getPosZ(), (int)(1.0F + this.getWidth() * 20.0F), (double)this.getWidth(), 0.0D, (double)this.getWidth(), (double)0.2F);
                serverworld.spawnParticle(ParticleTypes.FISHING, this.getPosX(), d3, this.getPosZ(), (int)(1.0F + this.getWidth() * 20.0F), (double)this.getWidth(), 0.0D, (double)this.getWidth(), (double)0.2F);
                this.ticksCatchable = MathHelper.nextInt(this.rand, 20, 40);
                this.getDataManager().set(DATA_CATCHING, true);
            }
        } else if (this.ticksCaughtDelay > 0) {
            this.ticksCaughtDelay -= i;
            float f5 = 0.15F;
            if (this.ticksCaughtDelay < 20) {
                f5 = (float)((double)f5 + (double)(20 - this.ticksCaughtDelay) * 0.05D);
            } else if (this.ticksCaughtDelay < 40) {
                f5 = (float)((double)f5 + (double)(40 - this.ticksCaughtDelay) * 0.02D);
            } else if (this.ticksCaughtDelay < 60) {
                f5 = (float)((double)f5 + (double)(60 - this.ticksCaughtDelay) * 0.01D);
            }

            if (this.rand.nextFloat() < f5) {
                float f6 = MathHelper.nextFloat(this.rand, 0.0F, 360.0F) * ((float)Math.PI / 180F);
                float f7 = MathHelper.nextFloat(this.rand, 25.0F, 60.0F);
                double d4 = this.getPosX() + (double)(MathHelper.sin(f6) * f7 * 0.1F);
                double d5 = (double)((float)MathHelper.floor(this.getPosY()) + 1.0F);
                double d6 = this.getPosZ() + (double)(MathHelper.cos(f6) * f7 * 0.1F);
                BlockState blockstate1 = serverworld.getBlockState(new BlockPos(d4, d5 - 1.0D, d6));
                if (serverworld.getBlockState(new BlockPos(d4, d5 - 1.0D, d6)).getMaterial() == net.minecraft.block.material.Material.WATER) {
                    serverworld.spawnParticle(ParticleTypes.SPLASH, d4, d5, d6, 2 + this.rand.nextInt(2), (double)0.1F, 0.0D, (double)0.1F, 0.0D);
                }
            }

            if (this.ticksCaughtDelay <= 0) {
                this.fishApproachAngle = MathHelper.nextFloat(this.rand, 0.0F, 360.0F);
                this.ticksCatchableDelay = MathHelper.nextInt(this.rand, 20, 80);
            }
        } else {
            this.ticksCaughtDelay = MathHelper.nextInt(this.rand, 100, 600);
            this.ticksCaughtDelay -= this.lureSpeed * 20 * 5;
        }

    }

    private boolean canFish(BlockPos p_234603_1_) {
        FiberglassFishingBobberEntity.WaterType fiberglassfishingbobberentity$watertype = FiberglassFishingBobberEntity.WaterType.INVALID;

        for(int i = -1; i <= 2; ++i) {
            FiberglassFishingBobberEntity.WaterType fiberglassfishingbobberentity$watertype1 = this.func_234602_a_(p_234603_1_.add(-2, i, -2), p_234603_1_.add(2, i, 2));
            switch(fiberglassfishingbobberentity$watertype1) {
                case INVALID:
                    return false;
                case ABOVE_WATER:
                    if (fiberglassfishingbobberentity$watertype == FiberglassFishingBobberEntity.WaterType.INVALID) {
                        return false;
                    }
                    break;
                case INSIDE_WATER:
                    if (fiberglassfishingbobberentity$watertype == FiberglassFishingBobberEntity.WaterType.ABOVE_WATER) {
                        return false;
                    }
            }

            fiberglassfishingbobberentity$watertype = fiberglassfishingbobberentity$watertype1;
        }

        return true;
    }

    private FiberglassFishingBobberEntity.WaterType func_234602_a_(BlockPos p_234602_1_, BlockPos p_234602_2_) {
        return BlockPos.getAllInBox(p_234602_1_, p_234602_2_).map(this::func_234604_c_).reduce((p_234601_0_, p_234601_1_) -> {
            return p_234601_0_ == p_234601_1_ ? p_234601_0_ : FiberglassFishingBobberEntity.WaterType.INVALID;
        }).orElse(FiberglassFishingBobberEntity.WaterType.INVALID);
    }

    private FiberglassFishingBobberEntity.WaterType func_234604_c_(BlockPos p_234604_1_) {
        BlockState blockstate = this.world.getBlockState(p_234604_1_);
        if (!blockstate.isAir() && !blockstate.isIn(Blocks.LILY_PAD)) {
            FluidState fluidstate = blockstate.getFluidState();
            return fluidstate.isTagged(FluidTags.WATER) && fluidstate.isSource() && blockstate.getCollisionShape(this.world, p_234604_1_).isEmpty() ? FiberglassFishingBobberEntity.WaterType.INSIDE_WATER : FiberglassFishingBobberEntity.WaterType.INVALID;
        } else {
            return FiberglassFishingBobberEntity.WaterType.ABOVE_WATER;
        }
    }


    @Override
    public int handleHookRetraction(@Nonnull ItemStack p_146034_1_) {
        PlayerEntity playerentity = this.func_234606_i_();
        if (!this.world.isRemote && playerentity != null) {
            int i = 0;
            net.minecraftforge.event.entity.player.ItemFishedEvent event = null;
            if (this.caughtEntity != null) {
                this.bringInHookedEntity();
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerentity, p_146034_1_, this, Collections.emptyList());
                this.world.setEntityState(this, (byte)31);
                i = this.caughtEntity instanceof ItemEntity ? 3 : 5;
            } else if (this.ticksCatchable > 0) {
                LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.world)).withParameter(LootParameters.field_237457_g_, this.getPositionVec()).withParameter(LootParameters.TOOL, p_146034_1_).withParameter(LootParameters.THIS_ENTITY, this).withRandom(this.rand).withLuck((float)this.luck + playerentity.getLuck());
                lootcontext$builder.withParameter(LootParameters.KILLER_ENTITY, Objects.requireNonNull(this.func_234616_v_())).withParameter(LootParameters.THIS_ENTITY, this);

                ResourceLocation BROTH_LOOT_TABLE = new ResourceLocation(CruelFishingMod.MODID, RegistryNames.DEMONIC_BROTH_LOOT_TABLE);

                LootTable lootTableVanilla = Objects.requireNonNull(this.world.getServer()).getLootTableManager().getLootTableFromLocation(LootTables.GAMEPLAY_FISHING);
                List<ItemStack> listVanilla = lootTableVanilla.generate(lootcontext$builder.build(LootParameterSets.FISHING));

                LootTable lootTableBroth = Objects.requireNonNull(this.world.getServer()).getLootTableManager().getLootTableFromLocation(BROTH_LOOT_TABLE);
                List<ItemStack> listBroth = lootTableBroth.generate(lootcontext$builder.build(LootParameterSets.FISHING));


                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerentity, p_146034_1_, this, listVanilla);

                double d = (float) MathHelper.floor(this.getBoundingBox().minY) + 1.0F;

                FluidState fluidState = this.world.getFluidState(new BlockPos(this.getPosX(), d - 1.0d, this.getPosZ()));

                if(fluidState.getFluid().getRegistryName().toString().equals(CruelFishingMod.MODID + ":" + RegistryNames.CORRUPTED_WATER_FLUID)
                || fluidState.getFluid().getRegistryName().toString().equals(CruelFishingMod.MODID + ":" + RegistryNames.CORRUPTED_WATER_FLOWING)) {
                    event = new net.minecraftforge.event.entity.player.ItemFishedEvent(listVanilla, this.onGround ? 2 : 1, this);
                    net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
                    if (event.isCanceled()) {
                        this.remove();
                        return event.getRodDamage();
                    }
                    for (ItemStack itemstack : listVanilla) {
                        EntityType<? extends FleshratFishEntity> entityType = CruelEntities.FLESHRAT_FISH_ENTITY;
                        Entity entity = entityType.spawn(((ServerWorld) this.world).getWorld(), itemstack, playerentity, this.getPosition().add(0, 0.5, 0), SpawnReason.MOB_SUMMONED, false, false);
                        entity.setInvulnerable(true);
                        entity.noClip = true;
                        entity.setNoGravity(true);
                    }
                } else if(fluidState.getFluid().getRegistryName().toString().equals(CruelFishingMod.MODID + ":" + RegistryNames.DEMONIC_BROTH_FLUID)
                || fluidState.getFluid().getRegistryName().toString().equals(CruelFishingMod.MODID + ":" + RegistryNames.DEMONIC_BROTH_FLOWING)) {
                    event = new net.minecraftforge.event.entity.player.ItemFishedEvent(listBroth, this.onGround ? 2 : 1, this);
                    net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
                    if (event.isCanceled()) {
                        this.remove();
                        return event.getRodDamage();
                    }
                    for (ItemStack itemstack : listBroth) {
                        ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), itemstack);
                        double d0 = playerentity.getPosX() - this.getPosX();
                        double d1 = playerentity.getPosY() - this.getPosY();
                        double d2 = playerentity.getPosZ() - this.getPosZ();
                        double d3 = 0.1D;
                        itementity.setMotion(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                        this.world.addEntity(itementity);
                        playerentity.world.addEntity(new ExperienceOrbEntity(playerentity.world, playerentity.getPosX(), playerentity.getPosY() + 0.5D, playerentity.getPosZ() + 0.5D, this.rand.nextInt(6) + 1));
                        if (itemstack.getItem().isIn(ItemTags.FISHES)) {
                            playerentity.addStat(Stats.FISH_CAUGHT, 1);
                        }
                    }
                }
                else {
                    event = new net.minecraftforge.event.entity.player.ItemFishedEvent(listVanilla, this.onGround ? 2 : 1, this);
                    net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
                    if (event.isCanceled()) {
                        this.remove();
                        return event.getRodDamage();
                    }
                    for (ItemStack itemstack : listVanilla) {
                        ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), itemstack);
                        double d0 = playerentity.getPosX() - this.getPosX();
                        double d1 = playerentity.getPosY() - this.getPosY();
                        double d2 = playerentity.getPosZ() - this.getPosZ();
                        double d3 = 0.1D;
                        itementity.setMotion(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                        this.world.addEntity(itementity);
                        playerentity.world.addEntity(new ExperienceOrbEntity(playerentity.world, playerentity.getPosX(), playerentity.getPosY() + 0.5D, playerentity.getPosZ() + 0.5D, this.rand.nextInt(6) + 1));
                        if (itemstack.getItem().isIn(ItemTags.FISHES)) {
                            playerentity.addStat(Stats.FISH_CAUGHT, 1);
                        }
                    }
                }


                i = 1;
            }

            if (this.onGround) {
                i = 2;
            }

            this.remove();
            return event == null ? i : event.getRodDamage();
        } else {
            return 0;
        }
    }


    @Override
    protected void bringInHookedEntity() {
        Entity entity = this.func_234616_v_();
        if (entity != null) {
            Vector3d vector3d = (new Vector3d(entity.getPosX() - this.getPosX(), entity.getPosY() - this.getPosY(), entity.getPosZ() - this.getPosZ())).scale(0.1D);
            this.caughtEntity.setMotion(this.caughtEntity.getMotion().add(vector3d));
        }
    }




    @Override
    @Nonnull
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    enum State {
        FLYING,
        HOOKED_IN_ENTITY,
        BOBBING
    }

    enum WaterType {
        ABOVE_WATER,
        INSIDE_WATER,
        INVALID
    }
}
