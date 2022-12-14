package com.igorstan.cruelfishing.entity.fish;

import com.igorstan.cruelfishing.playerdata.*;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.Timer;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FleshratFishEntity extends MobEntity {

    public FleshratFishEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_();
    }

    @Override
    public void tick() {

        if(!this.world.isRemote()) {
            this.rotationYaw += 20;
            this.rotationPitch += 20;
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) this.world.getClosestPlayer(this.getEntity(), 64f);
            if(playerEntity != null) {
                this.checkPlayer(playerEntity);
                double d0 = playerEntity.getPosX() - this.getPosX();
                double d1 = playerEntity.getPosY() - this.getPosY();
                double d2 = playerEntity.getPosZ() - this.getPosZ();
                this.setMotion(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
            }
        }
        super.tick();

    }

    private void checkPlayer(@Nonnull ServerPlayerEntity playerEntity) {
        if(getDistance(playerEntity.getEntity()) <= 1.1f) {
            IStockMarket iStockMarket = playerEntity.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
            iStockMarket.addFish(RegistryNames.FLESHRAT_FISH, 1);
            iStockMarket.setDead(true);
            this.setDead();
        }
    }

    @Override
    public int getEntityId() {
        return super.getEntityId();
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
    }


    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
    }

    private void syncPacket(ServerPlayerEntity entity, IStockMarket iStockMarket){
        new StockMarketClientPacket(iStockMarket.getDictionary(), iStockMarket.getDead()).sendToPlayer(entity);
    }
}