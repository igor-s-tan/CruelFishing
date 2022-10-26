package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.client.ClientRenderer;
import com.igorstan.cruelfishing.init.CruelItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
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
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientRenderer.register();
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
