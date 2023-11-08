package com.igorstan.cruelfishing.registry;

import com.google.common.collect.ImmutableSet;
import com.igorstan.cruelfishing.CruelResourses;
import com.igorstan.cruelfishing.FiberglassFishingHookEntity;
import com.igorstan.cruelfishing.FishEntity;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

import static com.igorstan.cruelfishing.CruelFishingMod.MODID;

public class CruelEntities {

    public static final DeferredRegister<EntityType<?>> CRUEL_ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static final RegistryObject<EntityType<FiberglassFishingHookEntity>> FIBERGLASS_HOOK = CRUEL_ENTITIES.register(CruelResourses.cruelFiberglassFishingHookEntity,
            () -> EntityType.Builder.<FiberglassFishingHookEntity>of((pEntityType, pLevel) -> {
                if(!pLevel.isClientSide) {
                    return new FiberglassFishingHookEntity(new FakePlayer((ServerLevel) pLevel, new GameProfile(UUID.randomUUID(), "")), pLevel, 0, 0);
                }
                else {
                    return new FiberglassFishingHookEntity(pLevel);
                }
            }, MobCategory.MISC).build(MODID + CruelResourses.cruelFiberglassFishingHookEntity));

//    public static final RegistryObject<EntityType<FishEntity>> FLESHRAT = CRUEL_ENTITIES.register(CruelResourses.fleshratFishEntity,
//            () -> EntityType.Builder.of(FishEntity::new, MobCategory.MISC).sized(1.0f, 1.0f).build(MODID + CruelResourses.fleshratFishEntity));

    public static final RegistryObject<EntityType<? extends FishEntity>> FLESHRAT = CRUEL_ENTITIES.register(CruelResourses.fleshratFishEntity, () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));

    private static <T extends Entity> EntityType<T> createEntityType(EntityType.EntityFactory<T> factory, EntityDimensions size) {
        return new EntityType<>(factory, MobCategory.MISC, true, true, false, true, ImmutableSet.of(), size, 5, 3, FeatureFlags.VANILLA_SET);
    }
}