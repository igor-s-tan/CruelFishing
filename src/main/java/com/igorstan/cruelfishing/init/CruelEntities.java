package com.igorstan.cruelfishing.init;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.entity.FiberglassFishingBobberEntity;
import com.igorstan.cruelfishing.entity.fish.FleshratFishEntity;
import com.igorstan.cruelfishing.entity.fish.model.FleshratFishModel;
import com.igorstan.cruelfishing.registry.RegistryNames;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;

import java.util.UUID;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(CruelFishingMod.MODID)
public class CruelEntities {


    public static final EntityType<FiberglassFishingBobberEntity> FIBERGLASS_BOBBER =
            register(RegistryNames.FIBERGLASS_BOBBER, EntityType.Builder.<FiberglassFishingBobberEntity>create(
                    (entityType, world) -> {
                        if(world.isRemote) {
                            return new FiberglassFishingBobberEntity(world);
                        } else {
                            return new FiberglassFishingBobberEntity(
                                    new FakePlayer((ServerWorld) world, new GameProfile(UUID.randomUUID(), "")), world, 0, 0
                            );
                        }
                    }, EntityClassification.MISC)
                    .size(0.25f, 0.25f)
                    .disableSerialization()
                    .disableSummoning()
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .immuneToFire()
                    .setUpdateInterval(5));

    public static final EntityType<FleshratFishEntity> FLESHRAT_FISH_ENTITY =
            register(RegistryNames.FLESHRAT_FISH, EntityType.Builder.<FleshratFishEntity>create(
                    FleshratFishEntity::new, EntityClassification.WATER_CREATURE)
                    .size(0.5f, 0.5f)
                    .disableSerialization()
                    .disableSummoning()
                    .setShouldReceiveVelocityUpdates(true)
                    .immuneToFire()
                    .setUpdateInterval(1)
                    .setTrackingRange(64));


    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation location = new ResourceLocation(CruelFishingMod.MODID, name);
        EntityType<T> entityType = builder.build(location.toString());
        entityType.setRegistryName(location);

        return entityType;
    }
}
