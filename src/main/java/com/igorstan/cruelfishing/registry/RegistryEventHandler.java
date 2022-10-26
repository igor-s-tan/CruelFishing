package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.block.CorruptedWaterBlock;
import com.igorstan.cruelfishing.fluid.CorruptedWaterFluid;
import com.igorstan.cruelfishing.init.CruelBlocks;
import com.igorstan.cruelfishing.init.CruelEntities;
import com.igorstan.cruelfishing.init.CruelItems;
import com.igorstan.cruelfishing.item.FiberglassFishingRodItem;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class RegistryEventHandler {
    public RegistryEventHandler() {
    }

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> evt) {
        evt.getRegistry().registerAll(
                CruelItems.FIBERGLASS_FISHING_ROD,
                CruelItems.CORRUPTED_WATER_BUCKET,

                CruelItems.FLESHRAT_FISH,
                CruelItems.CIVILIAN_FISH,
                CruelItems.BRAINY_FISH,
                CruelItems.POOLSUCKER_FISH,
                CruelItems.BRIMSTONE_FISH,
                CruelItems.DRIMP_FISH,
                CruelItems.GLOOMOID_FISH,
                CruelItems.SMALLMAN_FISH,
                CruelItems.BIGMAN_FISH,
                CruelItems.FISH_FISH,
                CruelItems.NIGHTFREAK_FISH,
                CruelItems.ZOOPER_FISH,
                CruelItems.CARABINO_FISH,
                CruelItems.MOONFISH_FISH,
                CruelItems.EEL_FISH,
                CruelItems.FLOUNDER_FISH,
                CruelItems.GIGA_FLOUNDER_FISH,
                CruelItems.BLURPO_FISH,
                CruelItems.HYDRA_FISH,
                CruelItems.PSYCHOFISH_FISH,
                CruelItems.BOUNCY_CASTLE_FISH,
                CruelItems.UNIDOR_FISH,
                CruelItems.NOCTER_FISH,
                CruelItems.HUMAN_FISH,
                CruelItems.BUBBLEFISH_FISH,
                CruelItems.FRAGFISH_FISH,
                CruelItems.FLIPPY_FISH,
                CruelItems.SKIPPY_FISH,
                CruelItems.GRABSHARK_FISH,
                CruelItems.DOLPHIN_FISH,
                CruelItems.OCTOSAUR_FISH,
                CruelItems.HEXASAUR_FISH,
                CruelItems.SLURPER_FISH,
                CruelItems.PIPER_FISH,
                CruelItems.BOGDO_FISH,
                CruelItems.SUPER_BOGDO_FISH,
                CruelItems.SWAMPSUCKER_FISH,
                CruelItems.SPIKER_FISH,
                CruelItems.GUNK_EEL_FISH,
                CruelItems.LUCK_SUCKER_FISH,
                CruelItems.BONBO_FISH,
                CruelItems.FISH_OF_WEALTH_FISH,
                CruelItems.COINY_FISH,
                CruelItems.WHEEL_OF_FORTURE_FISH,
                CruelItems.WHEEL_OF_PAIN_FISH,
                CruelItems.ZIPPY_3000_FISH,
                CruelItems.AGON_FISH,
                CruelItems.BOROION_FISH,
                CruelItems.CREEP_FISH,
                CruelItems.DELTAFORCE_FISH,
                CruelItems.ETERNITY_SLURPER_FISH,
                CruelItems.DOS_FISH_FISH,
                CruelItems.MISTAKE_FISH,
                CruelItems.SUCCESS_FISH,
                CruelItems.SUNFISH_FISH,
                CruelItems.CUBERT_FISH,
                CruelItems.GLURM_FISH,
                CruelItems.DARKFISH_FISH,
                CruelItems.DARKSLURPER_FISH,
                CruelItems.DARKSUCKER_FISH,
                CruelItems.ICEFISH_FISH,
                CruelItems.ICE_CUBERT_FISH,
                CruelItems.BLOSSOM_FISH,
                CruelItems.CHTHONNER_FISH,
                CruelItems.HEAD_FISH,
                CruelItems.PONDMAN_FISH,
                CruelItems.HELIPOD_FISH,
                CruelItems.ENGINE_OF_CHAOS_FISH,
                CruelItems.DEAD_FISH_FISH,
                CruelItems.TRANCER_FISH,
                CruelItems.FUZZOID_FISH,
                CruelItems.SOUL_FISH
        );
    }

    @SubscribeEvent
    public static void onEntityRegistry(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(CruelEntities.FIBERGLASS_BOBBER);
    }

    @SubscribeEvent
    public static void onFluidRegistry(RegistryEvent.Register<Fluid> evt) {
        evt.getRegistry().register(new CorruptedWaterFluid.Flowing().setRegistryName(RegistryNames.CORRUPTED_WATER_FLOWING));
        evt.getRegistry().register(new CorruptedWaterFluid.Source().setRegistryName(RegistryNames.CORRUPTED_WATER_FLUID));
    }

    @SubscribeEvent
    public static void onBlocksRegistry(RegistryEvent.Register<Block> evt) {
        evt.getRegistry().registerAll(new CorruptedWaterBlock().setRegistryName(RegistryNames.CORRUPTED_WATER_BLOCK));
    }

}
