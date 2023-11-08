package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.CruelNetworking;
import com.igorstan.cruelfishing.FishEntityRenderer;
import com.igorstan.cruelfishing.OpenTabletPacket;
import com.igorstan.cruelfishing.models.FleshratFishModel;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

import static com.igorstan.cruelfishing.CruelResourses.FLESHRAT_TEXTURE;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CruelClientEvents {

    public static KeyMapping openTabletKey;

    public static final ModelLayerLocation FLESHRAT_LAYER = new ModelLayerLocation(new ResourceLocation(CruelFishingMod.MODID, "fleshrat"), "main");

    @SubscribeEvent
    public static void entityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        EntityModelSet entityModelSet = Minecraft.getInstance().getEntityModels();
        event.registerEntityRenderer(CruelEntities.FLESHRAT.get(), ctx -> new FishEntityRenderer(ctx, new FleshratFishModel(entityModelSet.bakeLayer(FLESHRAT_LAYER)), FLESHRAT_TEXTURE));
    }

    @SubscribeEvent
    public static void layerRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FLESHRAT_LAYER, FleshratFishModel::createBodyLayer);
    }

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
        if(event.phase == Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            if(mc.screen == null && mc.getOverlay() == null && openTabletKey.consumeClick()) {
                CruelNetworking.INSTANCE.sendToServer(new OpenTabletPacket());
            }
        }

    }
}
