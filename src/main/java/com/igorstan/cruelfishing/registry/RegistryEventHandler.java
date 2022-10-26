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
                CruelItems.CORRUPTED_WATER_BUCKET
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
