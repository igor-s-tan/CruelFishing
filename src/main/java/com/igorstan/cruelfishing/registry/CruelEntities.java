package com.igorstan.cruelfishing.registry;

import com.google.common.collect.ImmutableSet;
import com.igorstan.cruelfishing.CruelResourses;
import com.igorstan.cruelfishing.entity.FiberglassFishingHookEntity;
import com.igorstan.cruelfishing.entity.FishEntity;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
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

    public static final RegistryObject<EntityType<? extends FishEntity>>  FLESHRAT_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.FLESHRAT_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  CIVILIAN_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.CIVILIAN_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BRAINY_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.BRAINY_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  POOLSUCKER_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.POOLSUCKER_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BRIMSTONE_ENTITY        = CRUEL_ENTITIES.register(CruelResourses.BRIMSTONE_FISH       , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DRIMP_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.DRIMP_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  GLOOMOID_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.GLOOMOID_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SMALLMAN_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.SMALLMAN_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BIGMAN_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.BIGMAN_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  FISH_ENTITY             = CRUEL_ENTITIES.register(CruelResourses.FISH_FISH            , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  NIGHTFREAK_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.NIGHTFREAK_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  ZOOPER_ENTITYr          = CRUEL_ENTITIES.register(CruelResourses.ZOOPER_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  CARABINO_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.CARABINO_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  MOONFISH_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.MOONFISH_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  EEL_ENTITY              = CRUEL_ENTITIES.register(CruelResourses.EEL_FISH             , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  FLOUNDER_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.FLOUNDER_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  GIGA_FLOUNDER_ENTITY    = CRUEL_ENTITIES.register(CruelResourses.GIGA_FLOUNDER_FISH   , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BLURPO_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.BLURPO_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  HYDRA_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.HYDRA_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  PSYCHOFISH_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.PSYCHOFISH_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BOUNCY_CASTLE_ENTITY    = CRUEL_ENTITIES.register(CruelResourses.BOUNCY_CASTLE_FISH   , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  UNIDOR_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.UNIDOR_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  NOCTER_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.NOCTER_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  HUMAN_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.HUMAN_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BUBBLEFISH_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.BUBBLEFISH_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  FRAGFISH_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.FRAGFISH_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  FLIPPY_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.FLIPPY_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SKIPPY_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.SKIPPY_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  GRABSHARK_ENTITY        = CRUEL_ENTITIES.register(CruelResourses.GRABSHARK_FISH       , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DOLPHIN_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.DOLPHIN_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  OCTOSAUR_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.OCTOSAUR_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  HEXASAUR_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.HEXASAUR_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SLURPER_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.SLURPER_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  PIPER_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.PIPER_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BOGDO_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.BOGDO_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SUPER_BOGDO_ENTITY      = CRUEL_ENTITIES.register(CruelResourses.SUPER_BOGDO_FISH     , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SWAMPSUCKER_ENTITY      = CRUEL_ENTITIES.register(CruelResourses.SWAMPSUCKER_FISH     , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SPIKER_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.SPIKER_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  GUNK_EEL_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.GUNK_EEL_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  LUCK_SUCKER_ENTITY      = CRUEL_ENTITIES.register(CruelResourses.LUCK_SUCKER_FISH     , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BONBO_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.BONBO_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  FISH_OF_WEALTH_ENTITY   = CRUEL_ENTITIES.register(CruelResourses.FISH_OF_WEALTH_FISH  , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  COINY_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.COINY_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  WHEEL_OF_FORTURE_ENTITY = CRUEL_ENTITIES.register(CruelResourses.WHEEL_OF_FORTURE_FISH, () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  WHEEL_OF_PAIN_ENTITY    = CRUEL_ENTITIES.register(CruelResourses.WHEEL_OF_PAIN_FISH   , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  ZIPPY_3000_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.ZIPPY_3000_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  AGON_ENTITY             = CRUEL_ENTITIES.register(CruelResourses.AGON_FISH            , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BOROION_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.BOROION_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  CREEP_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.CREEP_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DELTAFORCE_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.DELTAFORCE_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  ETERNITY_SLURPER_ENTITY = CRUEL_ENTITIES.register(CruelResourses.ETERNITY_SLURPER_FISH, () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DOS_ENTITY_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.DOS_FISH_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  MISTAKE_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.MISTAKE_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SUCCESS_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.SUCCESS_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SUNFISH_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.SUNFISH_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  CUBERT_ENTITY           = CRUEL_ENTITIES.register(CruelResourses.CUBERT_FISH          , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  GLURM_ENTITY            = CRUEL_ENTITIES.register(CruelResourses.GLURM_FISH           , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DARKFISH_ENTITY         = CRUEL_ENTITIES.register(CruelResourses.DARKFISH_FISH        , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DARKSLURPER_ENTITY      = CRUEL_ENTITIES.register(CruelResourses.DARKSLURPER_FISH     , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DARKSUCKER_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.DARKSUCKER_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  ICEFISH_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.ICEFISH_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  ICE_CUBERT_ENTITY       = CRUEL_ENTITIES.register(CruelResourses.ICE_CUBERT_FISH      , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  BLOSSOM_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.BLOSSOM_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  CHTHONNER_ENTITY        = CRUEL_ENTITIES.register(CruelResourses.CHTHONNER_FISH       , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  HEAD_ENTITY             = CRUEL_ENTITIES.register(CruelResourses.HEAD_FISH            , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  PONDMAN_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.PONDMAN_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  HELIPOD_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.HELIPOD_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  ENGINE_OF_CHAOS_ENTITY  = CRUEL_ENTITIES.register(CruelResourses.ENGINE_OF_CHAOS_FISH , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  DEAD_ENTITY_ENTITY      = CRUEL_ENTITIES.register(CruelResourses.DEAD_FISH_FISH       , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  TRANCER_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.TRANCER_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  FUZZOID_ENTITY          = CRUEL_ENTITIES.register(CruelResourses.FUZZOID_FISH         , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));
    public static final RegistryObject<EntityType<? extends FishEntity>>  SOUL_ENTITY             = CRUEL_ENTITIES.register(CruelResourses.SOUL_FISH            , () -> createEntityType(FishEntity::new, EntityDimensions.scalable(1.0f, 1.0f)));





    private static <T extends Entity> EntityType<T> createEntityType(EntityType.EntityFactory<T> factory, EntityDimensions size) {
        return new EntityType<>(factory, MobCategory.MISC, true, true, false, true, ImmutableSet.of(), size, 5, 3, FeatureFlags.VANILLA_SET);
    }
}