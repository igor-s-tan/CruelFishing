package com.igorstan.cruelfishing;


import com.igorstan.cruelfishing.client.ClientContainerRegistry;
import com.igorstan.cruelfishing.client.ClientModelRenderer;
import com.igorstan.cruelfishing.container.StockMarketTabletScreen;
import com.igorstan.cruelfishing.entity.display.TextDisplay;
import com.igorstan.cruelfishing.entity.fish.render.FleshratFishModelRenderer;
import com.igorstan.cruelfishing.init.CruelEntities;
import com.igorstan.cruelfishing.init.CruelItems;
import com.igorstan.cruelfishing.network.Network;
import com.igorstan.cruelfishing.playerdata.IStockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarketStorage;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;


@Mod(CruelFishingMod.MODID)
public class CruelFishingMod
{
    public static final String MODID = "cruelfishing";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup CRUEL_GROUP = new ItemGroup("CruelFishingTab") {
        @Override
        public ItemStack createIcon() {
            return CruelItems.FIBERGLASS_FISHING_ROD.getDefaultInstance();
        }
    };

    public CruelFishingMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);



    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        CapabilityManager.INSTANCE.register(IStockMarket.class, new StockMarketStorage(), StockMarket::new);
        Network.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientModelRenderer.register();
        ScreenManager.registerFactory(ClientContainerRegistry.stockMarketTabletContainerContainerType, StockMarketTabletScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(CruelEntities.FLESHRAT_FISH_ENTITY, FleshratFishModelRenderer::new);
        MinecraftForge.EVENT_BUS.register(new TextDisplay());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("cruelfishing", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

}
