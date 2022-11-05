package com.igorstan.cruelfishing.entity.fish.model;

import com.igorstan.cruelfishing.entity.fish.FleshratFishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class FleshratFishModel<T extends FleshratFishEntity> extends EntityModel<T> {
    private final ModelRenderer bb_main;

    public FleshratFishModel() {
        textureWidth = 32;
        textureHeight = 32;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 18).addBox(-1.0F, -2.0F, 3.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -5.0F, 5.0F, 3.0F, 8.0F, 0.0F, false);
        bb_main.setTextureOffset(18, 0).addBox(-1.0F, -3.0F, -10.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 11).addBox(-1.0F, -2.0F, -10.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 4).addBox(2.0F, -2.0F, -10.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bb_main.setTextureOffset(16, 19).addBox(0.0F, -2.0F, 8.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bb_main.setTextureOffset(11, 13).addBox(-1.0F, -4.0F, -4.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
        bb_main.setTextureOffset(11, 11).addBox(-2.0F, -2.0F, -11.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -10.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
