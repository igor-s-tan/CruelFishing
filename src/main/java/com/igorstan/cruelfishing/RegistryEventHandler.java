package com.igorstan.cruelfishing;

import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.combustivefishing.common.entity.AbstractLavaFishEntity;
import top.theillusivec4.combustivefishing.common.item.*;
import top.theillusivec4.combustivefishing.common.registry.CombustiveFishingEntities;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class RegistryEventHandler {
    public RegistryEventHandler() {
    }

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> evt) {
        evt.getRegistry().registerAll(new FiberglassFishingRod());
    }
    @SubscribeEvent
    public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(Entities.FIBERGLASS_BOBBER);
    }
}
