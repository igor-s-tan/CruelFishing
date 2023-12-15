package com.igorstan.cruelfishing.client.model;

import com.igorstan.cruelfishing.entity.FishEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import static java.lang.Math.PI;


public class FleshratFishModel<T extends FishEntity> extends EntityModel<T> {
    private final ModelPart bb_main;

    public FleshratFishModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -2.0F, 3.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -3.0F, -5.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(-1.0F, -3.0F, -10.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-1.0F, -2.0F, -10.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(2.0F, -2.0F, -10.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 19).addBox(0.0F, -2.0F, 8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(11, 13).addBox(-1.0F, -4.0F, -4.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(-2.0F, -2.0F, -11.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -2.0F, -10.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }



    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.bb_main.yRot = pEntity.getYRot();
        this.bb_main.xRot = (float) (PI);
    }
}