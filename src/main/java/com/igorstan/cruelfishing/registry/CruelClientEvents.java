package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.CruelNetworking;
import com.igorstan.cruelfishing.OpenTabletPacket;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CruelClientEvents {

    public static KeyMapping openTabletKey;

    static {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(CruelClientEvents::registerKeyBindings);
    }

    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
        openTabletKey = new KeyMapping("key.tablet_open.desc", GLFW.GLFW_KEY_TAB, "key.cruelfishing.category");
        event.register(openTabletKey);
    }

    @SubscribeEvent
    public static void onClientPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            if(mc.screen == null && mc.getOverlay() == null && openTabletKey.consumeClick()) {
                CruelNetworking.INSTANCE.sendToServer(new OpenTabletPacket());
            }
        }

    }




}
