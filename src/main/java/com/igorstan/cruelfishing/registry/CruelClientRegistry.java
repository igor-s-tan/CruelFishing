package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.FishEntityRenderer;
import com.igorstan.cruelfishing.models.FleshratFishModel;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.igorstan.cruelfishing.CruelResourses.FLESHRAT_TEXTURE;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CruelClientRegistry {

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

}
