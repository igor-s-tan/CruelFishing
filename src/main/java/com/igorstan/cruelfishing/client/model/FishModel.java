package com.igorstan.cruelfishing.client.model;

import com.igorstan.cruelfishing.entity.FishEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;

import static java.lang.Math.PI;

public class FishModel <T extends FishEntity> extends EntityModel<T> {

    protected ModelPart bb_main;

    public FishModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    @Override
    public void setupAnim(FishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bb_main.yRot = entity.getYRot();
        this.bb_main.xRot = (float) (PI);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
