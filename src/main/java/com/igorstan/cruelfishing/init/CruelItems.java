package com.igorstan.cruelfishing.init;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.item.FiberglassFishingRodItem;
import com.igorstan.cruelfishing.item.FishItem;
import com.igorstan.cruelfishing.item.StockMarketTabletItem;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(CruelFishingMod.MODID)
public class CruelItems {

    public static final Item FIBERGLASS_FISHING_ROD =
            register(new FiberglassFishingRodItem(new Item.Properties().defaultMaxDamage(128).group(CruelFishingMod.CRUEL_GROUP)), RegistryNames.FIBERGLASS_FISHING_ROD);


    public static final Item CORRUPTED_WATER_BUCKET =
            register(new BucketItem(() -> CruelFluids.CORRUPTED_WATER_FLUID, new Item.Properties().maxStackSize(1).group(CruelFishingMod.CRUEL_GROUP)), RegistryNames.CORRUPTED_WATER_BUCKET);

    public static final Item STOCK_MARKET_TABLET =
            register(new StockMarketTabletItem(72, RegistryNames.STOCK_MARKET_TABLET_DISPLAY_NAME), RegistryNames.STOCK_MARKET_TABLET);

    public static final Item FLESHRAT_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FLESHRAT_FISH_DESCRIPTION), RegistryNames.FLESHRAT_FISH);
    public static final Item CIVILIAN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.CIVILIAN_FISH_DESCRIPTION), RegistryNames.CIVILIAN_FISH);
    public static final Item BRAINY_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BRAINY_FISH_DESCRIPTION), RegistryNames.BRAINY_FISH);
    public static final Item POOLSUCKER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.POOLSUCKER_FISH_DESCRIPTION), RegistryNames.POOLSUCKER_FISH);
    public static final Item BRIMSTONE_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BRIMSTONE_FISH_DESCRIPTION), RegistryNames.BRIMSTONE_FISH);
    public static final Item DRIMP_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DRIMP_FISH_DESCRIPTION), RegistryNames.DRIMP_FISH);
    public static final Item GLOOMOID_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.GLOOMOID_FISH_DESCRIPTION), RegistryNames.GLOOMOID_FISH);
    public static final Item SMALLMAN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SMALLMAN_FISH_DESCRIPTION), RegistryNames.SMALLMAN_FISH);
    public static final Item BIGMAN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BIGMAN_FISH_DESCRIPTION), RegistryNames.BIGMAN_FISH);
    public static final Item FISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FISH_FISH_DESCRIPTION), RegistryNames.FISH_FISH);
    public static final Item NIGHTFREAK_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.NIGHTFREAK_FISH_DESCRIPTION), RegistryNames.NIGHTFREAK_FISH);
    public static final Item ZOOPER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.ZOOPER_FISH_DESCRIPTION), RegistryNames.ZOOPER_FISH);
    public static final Item CARABINO_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.CARABINO_FISH_DESCRIPTION), RegistryNames.CARABINO_FISH);
    public static final Item MOONFISH_FISH =
            register(new FishItem(new Item.Properties().group(CruelFishingMod.CRUEL_GROUP), RegistryNames.MOONFISH_FISH_DESCRIPTION), RegistryNames.MOONFISH_FISH);
    public static final Item EEL_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.EEL_FISH_DESCRIPTION), RegistryNames.EEL_FISH);
    public static final Item FLOUNDER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FLOUNDER_FISH_DESCRIPTION), RegistryNames.FLOUNDER_FISH);
    public static final Item GIGA_FLOUNDER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.GIGA_FLOUNDER_FISH_DESCRIPTION), RegistryNames.GIGA_FLOUNDER_FISH);
    public static final Item BLURPO_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BLURPO_FISH_DESCRIPTION), RegistryNames.BLURPO_FISH);
    public static final Item HYDRA_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.HYDRA_FISH_DESCRIPTION), RegistryNames.HYDRA_FISH);
    public static final Item PSYCHOFISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.PSYCHOFISH_FISH_DESCRIPTION), RegistryNames.PSYCHOFISH_FISH);
    public static final Item BOUNCY_CASTLE_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BOUNCY_CASTLE_FISH_DESCRIPTION), RegistryNames.BOUNCY_CASTLE_FISH);
    public static final Item UNIDOR_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.UNIDOR_FISH_DESCRIPTION), RegistryNames.UNIDOR_FISH);
    public static final Item NOCTER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.NOCTER_FISH_DESCRIPTION), RegistryNames.NOCTER_FISH);
    public static final Item HUMAN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.HUMAN_FISH_DESCRIPTION), RegistryNames.HUMAN_FISH);
    public static final Item BUBBLEFISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BUBBLEFISH_FISH_DESCRIPTION), RegistryNames.BUBBLEFISH_FISH);
    public static final Item FRAGFISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FRAGFISH_FISH_DESCRIPTION), RegistryNames.FRAGFISH_FISH);
    public static final Item FLIPPY_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FLIPPY_FISH_DESCRIPTION), RegistryNames.FLIPPY_FISH);
    public static final Item SKIPPY_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SKIPPY_FISH_DESCRIPTION), RegistryNames.SKIPPY_FISH);
    public static final Item GRABSHARK_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.GRABSHARK_FISH_DESCRIPTION), RegistryNames.GRABSHARK_FISH);
    public static final Item DOLPHIN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DOLPHIN_FISH_DESCRIPTION), RegistryNames.DOLPHIN_FISH);
    public static final Item OCTOSAUR_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.OCTOSAUR_FISH_DESCRIPTION), RegistryNames.OCTOSAUR_FISH);
    public static final Item HEXASAUR_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.HEXASAUR_FISH_DESCRIPTION), RegistryNames.HEXASAUR_FISH);
    public static final Item SLURPER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SLURPER_FISH_DESCRIPTION), RegistryNames.SLURPER_FISH);
    public static final Item PIPER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.PIPER_FISH_DESCRIPTION), RegistryNames.PIPER_FISH);
    public static final Item BOGDO_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BOGDO_FISH_DESCRIPTION), RegistryNames.BOGDO_FISH);
    public static final Item SUPER_BOGDO_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SUPER_BOGDO_FISH_DESCRIPTION), RegistryNames.SUPER_BOGDO_FISH);
    public static final Item SWAMPSUCKER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SWAMPSUCKER_FISH_DESCRIPTION), RegistryNames.SWAMPSUCKER_FISH);
    public static final Item SPIKER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SPIKER_FISH_DESCRIPTION), RegistryNames.SPIKER_FISH);
    public static final Item GUNK_EEL_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.GUNK_EEL_FISH_DESCRIPTION), RegistryNames.GUNK_EEL_FISH);
    public static final Item LUCK_SUCKER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.LUCK_SUCKER_FISH_DESCRIPTION), RegistryNames.LUCK_SUCKER_FISH);
    public static final Item BONBO_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BONBO_FISH_DESCRIPTION), RegistryNames.BONBO_FISH);
    public static final Item FISH_OF_WEALTH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FISH_OF_WEALTH_FISH_DESCRIPTION), RegistryNames.FISH_OF_WEALTH_FISH);
    public static final Item COINY_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.COINY_FISH_DESCRIPTION), RegistryNames.COINY_FISH);
    public static final Item WHEEL_OF_FORTURE_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.WHEEL_OF_FORTURE_FISH_DESCRIPTION), RegistryNames.WHEEL_OF_FORTURE_FISH);
    public static final Item WHEEL_OF_PAIN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.WHEEL_OF_PAIN_FISH_DESCRIPTION), RegistryNames.WHEEL_OF_PAIN_FISH);
    public static final Item ZIPPY_3000_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.ZIPPY_3000_FISH_DESCRIPTION), RegistryNames.ZIPPY_3000_FISH);
    public static final Item AGON_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.AGON_FISH_DESCRIPTION), RegistryNames.AGON_FISH);
    public static final Item BOROION_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BOROION_FISH_DESCRIPTION), RegistryNames.BOROION_FISH);
    public static final Item CREEP_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.CREEP_FISH_DESCRIPTION), RegistryNames.CREEP_FISH);
    public static final Item DELTAFORCE_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DELTAFORCE_FISH_DESCRIPTION), RegistryNames.DELTAFORCE_FISH);
    public static final Item ETERNITY_SLURPER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.ETERNITY_SLURPER_FISH_DESCRIPTION), RegistryNames.ETERNITY_SLURPER_FISH);
    public static final Item DOS_FISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DOS_FISH_FISH_DESCRIPTION), RegistryNames.DOS_FISH_FISH);
    public static final Item MISTAKE_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.MISTAKE_FISH_DESCRIPTION), RegistryNames.MISTAKE_FISH);
    public static final Item SUCCESS_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SUCCESS_FISH_DESCRIPTION), RegistryNames.SUCCESS_FISH);
    public static final Item SUNFISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SUNFISH_FISH_DESCRIPTION), RegistryNames.SUNFISH_FISH);
    public static final Item CUBERT_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.CUBERT_FISH_DESCRIPTION), RegistryNames.CUBERT_FISH);
    public static final Item GLURM_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.GLURM_FISH_DESCRIPTION), RegistryNames.GLURM_FISH);
    public static final Item DARKFISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DARKFISH_FISH_DESCRIPTION), RegistryNames.DARKFISH_FISH);
    public static final Item DARKSLURPER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DARKSLURPER_FISH_DESCRIPTION), RegistryNames.DARKSLURPER_FISH);
    public static final Item DARKSUCKER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DARKSUCKER_FISH_DESCRIPTION), RegistryNames.DARKSUCKER_FISH);
    public static final Item ICEFISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.ICEFISH_FISH_DESCRIPTION), RegistryNames.ICEFISH_FISH);
    public static final Item ICE_CUBERT_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.ICE_CUBERT_FISH_DESCRIPTION), RegistryNames.ICE_CUBERT_FISH);
    public static final Item BLOSSOM_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.BLOSSOM_FISH_DESCRIPTION), RegistryNames.BLOSSOM_FISH);
    public static final Item CHTHONNER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.CHTHONNER_FISH_DESCRIPTION), RegistryNames.CHTHONNER_FISH);
    public static final Item HEAD_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.HEAD_FISH_DESCRIPTION), RegistryNames.HEAD_FISH);
    public static final Item PONDMAN_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.PONDMAN_FISH_DESCRIPTION), RegistryNames.PONDMAN_FISH);
    public static final Item HELIPOD_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.HELIPOD_FISH_DESCRIPTION), RegistryNames.HELIPOD_FISH);
    public static final Item ENGINE_OF_CHAOS_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.ENGINE_OF_CHAOS_FISH_DESCRIPTION), RegistryNames.ENGINE_OF_CHAOS_FISH);
    public static final Item DEAD_FISH_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.DEAD_FISH_FISH_DESCRIPTION), RegistryNames.DEAD_FISH_FISH);
    public static final Item TRANCER_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.TRANCER_FISH_DESCRIPTION), RegistryNames.TRANCER_FISH);
    public static final Item FUZZOID_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.FUZZOID_FISH_DESCRIPTION), RegistryNames.FUZZOID_FISH);
    public static final Item SOUL_FISH =
            register(new FishItem(new Item.Properties(), RegistryNames.SOUL_FISH_DESCRIPTION), RegistryNames.SOUL_FISH);

    public static Item register(@Nonnull Item item, @Nonnull String name) {
        return register(item, new ResourceLocation(CruelFishingMod.MODID, name));
    }

    public static Item register(@Nonnull Item item, @Nonnull ResourceLocation registryName) {
        item.setRegistryName(registryName);
        return item;
    }
}

