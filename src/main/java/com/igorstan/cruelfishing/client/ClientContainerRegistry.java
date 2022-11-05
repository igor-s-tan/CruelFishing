package com.igorstan.cruelfishing.client;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.container.StockMarketTabletContainer;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientContainerRegistry {


    @SubscribeEvent
    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> evt) {
        IForgeRegistry<ContainerType<?>> registry = evt.getRegistry();
        registry.register(IForgeContainerType.create(((windowId, inv, data) ->
                new StockMarketTabletContainer(windowId, inv, inv.player))).setRegistryName(RegistryNames.STOCK_MARKET_TABLET_CONTAINER));
    }
    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.STOCK_MARKET_TABLET_CONTAINER)
    public static ContainerType<StockMarketTabletContainer> stockMarketTabletContainerContainerType;
}
