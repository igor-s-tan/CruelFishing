package com.igorstan.cruelfishing;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class FishEntityRenderer<T extends FishEntity> extends EntityRenderer<T> {

    protected final EntityModel<T> fishEntityModel;
    private ResourceLocation texture;

    public FishEntityRenderer(EntityRendererProvider.Context ctx, EntityModel<T> fishEntityModel, ResourceLocation texture) {
        super(ctx);
        this.fishEntityModel = fishEntityModel;
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(FishEntity pEntity) {
        return this.texture;
    }


    @Override
    public void render(T fishEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        VertexConsumer vertexConsumer = buffer.getBuffer(fishEntityModel.renderType(this.texture));
        fishEntityModel.setupAnim(fishEntity, partialTicks, 0, 0, entityYaw, 0);
        fishEntityModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
        super.render(fishEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }


}
