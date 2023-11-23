package com.igorstan.cruelfishing;

import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class FishEntity extends LivingEntity {

    public static final EntityDataAccessor<Float> DATA_ACCESSOR_SPEED = SynchedEntityData.defineId(FishEntity.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<String> DATA_ACCESSOR_FISHERMAN = SynchedEntityData.defineId(FishEntity.class, EntityDataSerializers.STRING);

    public FishEntity(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setRotYSpeed(0.0f);
        this.setMoveToFisherman(null);
        this.setNoGravity(true);
        this.setInvulnerable(true);
        this.noPhysics = true;

        //this.yHeadRot = this.getYRot();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ACCESSOR_SPEED, 0.0f);
        this.entityData.define(DATA_ACCESSOR_FISHERMAN, CruelResourses.NULL_UUID);
    }

//    @Override
//    public void setYBodyRot(float pOffset) {
//        this.yBodyRot = pOffset;
//    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
    }

    @Override
    public void tick() {
        super.tick();


        String playerUUID = this.getFishermanUUID();
        Player player = this.level.getPlayerByUUID(UUID.fromString(playerUUID));
        if (!playerUUID.equals(CruelResourses.NULL_UUID)) {
            if(checkPlayerNearby(player)) {
                this.remove(RemovalReason.DISCARDED);
                this.setRotYSpeed(0.0f);
                this.setMoveToFisherman(null);

                player.getCapability(PortfolioCapability.PORTFOLIO).ifPresent(portfolio -> {
                    portfolio.addAmount(CruelResourses.fleshratFishEntity, 1);
                });

            }
            this.setRotYSpeed(0.4f);
            this.setMoveToFisherman(player);
            double d0 = player.getX() - this.getX();
            double d1 = player.getY() - this.getY();
            double d2 = player.getZ() - this.getZ();
            double speed = 0.2D;
            this.setDeltaMovement(d0 * speed, d1 * speed + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.01D, d2 * speed);
        }


        this.setYRot(this.getYRot() + this.getRotYSpeed());
//        Vec3 vec3 = this.getDeltaMovement();
//        this.setPos(new Vec3(this.getX(), this.getY(), this.getZ()).add(vec3));

        this.yBodyRotO = this.yBodyRot;
        this.yHeadRotO = this.yHeadRot;
    }


    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setRotYSpeed(pCompound.getFloat("rotYSpeed"));
        String playerUUID = pCompound.getString("fisherman");
        if(!playerUUID.equals(CruelResourses.NULL_UUID)) {
            Player player = this.level.getPlayerByUUID(UUID.fromString(playerUUID));
            this.setMoveToFisherman(player);
        }
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return Collections.singleton(ItemStack.EMPTY);
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot pSlot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {

    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putFloat("rotYSpeed", this.getRotYSpeed());
        String playerUUID = this.getFishermanUUID();
        if(!playerUUID.equals(CruelResourses.NULL_UUID)) {
            pCompound.putString("fisherman", playerUUID);
        }
        else {
            pCompound.putString("fisherman", CruelResourses.NULL_UUID);
        }
    }

    public void setRotYSpeed(float rotYSpeed) {
        this.getEntityData().set(DATA_ACCESSOR_SPEED, rotYSpeed);
    }

    public float getRotYSpeed() {
        return this.getEntityData().get(DATA_ACCESSOR_SPEED);
    }

    public void setMoveToFisherman(Player player) {
        if(player != null) {
            this.getEntityData().set(DATA_ACCESSOR_FISHERMAN, player.getStringUUID());
        }
        else
        {
            this.getEntityData().set(DATA_ACCESSOR_FISHERMAN, CruelResourses.NULL_UUID);
        }
    }

    public String getFishermanUUID() {
        return this.getEntityData().get(DATA_ACCESSOR_FISHERMAN);
    }

    private boolean checkPlayerNearby(Player player) {
        return this.distanceTo(player) <= 0.2f || this.distanceTo(player) > 1026.0D;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket pPacket) {
        super.recreateFromPacket(pPacket);
//        double d0 = pPacket.getX();
//        double d1 = pPacket.getY();
//        double d2 = pPacket.getZ();
//        float f = pPacket.getYRot();
//        float f1 = pPacket.getXRot();
//        this.syncPacketPositionCodec(d0, d1, d2);
//        this.yBodyRot = pPacket.getYHeadRot();
//        this.yHeadRot = pPacket.getYHeadRot();
//        this.yBodyRotO = this.yBodyRot;
//        this.yHeadRotO = this.yHeadRot;
//        this.setId(pPacket.getId());
//        this.setUUID(pPacket.getUUID());
//        this.absMoveTo(d0, d1, d2, f, f1);
//        this.setDeltaMovement(pPacket.getXa(), pPacket.getYa(), pPacket.getZa());
    }

    public static AttributeSupplier.Builder getCruelAttributes() {
        return LivingEntity.createLivingAttributes();
    }



}
