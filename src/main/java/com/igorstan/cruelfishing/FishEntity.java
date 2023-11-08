package com.igorstan.cruelfishing;

import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class FishEntity extends Entity {

    public static final EntityDataAccessor<Float> DATA_ACCESSOR_SPEED = SynchedEntityData.defineId(FishEntity.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<String> DATA_ACCESSOR_FISHERMAN = SynchedEntityData.defineId(FishEntity.class, EntityDataSerializers.STRING);

    public FishEntity(EntityType<? extends Entity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setRotYSpeed(0.0f);
        this.setMoveToFisherman(null);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ACCESSOR_SPEED, 0.0f);
        this.entityData.define(DATA_ACCESSOR_FISHERMAN, CruelResourses.NULL_UUID);
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
            this.setRotYSpeed(0.5f);
            this.setMoveToFisherman(player);
            double d0 = player.getX() - this.getX();
            double d1 = player.getY() - this.getY();
            double d2 = player.getZ() - this.getZ();
            this.setDeltaMovement(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.02D, d2 * 0.1D);
        }


        this.setYRot(this.getYRot() + this.getRotYSpeed());
        Vec3 vec3 = this.getDeltaMovement();
        this.setPos(new Vec3(this.getX(), this.getY(), this.getZ()).add(vec3));
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        this.setRotYSpeed(pCompound.getFloat("rotYSpeed"));
        String playerUUID = pCompound.getString("fisherman");
        if(!playerUUID.equals(CruelResourses.NULL_UUID)) {
            Player player = this.level.getPlayerByUUID(UUID.fromString(playerUUID));
            this.setMoveToFisherman(player);
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putFloat("rotYSpeed", this.getRotYSpeed());
        String playerUUID = this.getFishermanUUID();
        if(!playerUUID.equals(CruelResourses.NULL_UUID)) {
            pCompound.putString("fisherman", playerUUID);
        }
        else
        {
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
        return this.distanceTo(player) <= 1.1f;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }



}
