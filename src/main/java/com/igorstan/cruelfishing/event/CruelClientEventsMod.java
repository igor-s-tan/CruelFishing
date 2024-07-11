package com.igorstan.cruelfishing.event;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.Fishes;
import com.igorstan.cruelfishing.client.FishEntityRenderer;
import com.igorstan.cruelfishing.client.model.FishModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CruelClientEventsMod {

    @SubscribeEvent
    public static void entityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        EntityModelSet entityModelSet = Minecraft.getInstance().getEntityModels();
        for(Fishes fish: Fishes.values()) {
            event.registerEntityRenderer(fish.getEntityObject().get(), ctx -> new FishEntityRenderer(ctx, new FishModel(entityModelSet.bakeLayer(fish.getLayer())), fish.getTexture()));
        }
    }

    @SubscribeEvent
    public static void layerRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for(Fishes fish: Fishes.values()) {
            event.registerLayerDefinition(fish.getLayer(), fish::getLayerDefinition);
        }
    }

}
