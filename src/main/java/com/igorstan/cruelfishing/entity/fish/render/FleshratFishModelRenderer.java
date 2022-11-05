package com.igorstan.cruelfishing.entity.fish.render;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.entity.fish.FleshratFishEntity;
import com.igorstan.cruelfishing.entity.fish.model.FleshratFishModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FleshratFishModelRenderer extends MobRenderer<FleshratFishEntity, FleshratFishModel<FleshratFishEntity>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(CruelFishingMod.MODID, "textures/entity/fleshrat_texture.png");

    public FleshratFishModelRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new FleshratFishModel<>(), 0.0F);
    }
    @Override
    public ResourceLocation getEntityTexture(FleshratFishEntity entity) {
        return TEXTURE;
    }
}
