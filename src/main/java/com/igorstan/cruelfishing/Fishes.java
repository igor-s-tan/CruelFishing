package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.entity.FishEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.RegistryObject;

public enum Fishes {

    FLESHRAT("fleshrat", "Fleshrat", "Hey! That's a fleshrat! Disgusting.", () -> {
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
    }),
    CIVILIAN("civilian", "Civilian", "There are all over the place. Not worth much.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -7.0F, -1.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 11).addBox(-1.0F, -12.0F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 7).addBox(-1.0F, -9.0F, -4.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-1.0F, -9.0F, 2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-2.0F, -9.0F, -1.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 19).addBox(-2.0F, -12.0F, -0.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.25F, -5.25F, 0.2618F, 0.0F, 0.0F));
        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.25F, 6.25F, -0.2618F, 0.0F, 0.0F));
        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.75F, -1.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.75F, 1.75F, 0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 4).addBox(-2.0F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.055F, -0.7596F, 2.5F, 1.5708F, 1.3963F, 1.5708F));
        PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 16).addBox(-1.0F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.055F, -0.7596F, -1.5F, -1.5708F, 1.3963F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }),
    BRAINY("brainy", "Brainy", "Too intelligent for its own good, it despises living in fish society.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 13).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-2.0F, -1.0F, 3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(20, 20).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(4, 6).addBox(-2.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 20).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-2.0F, -5.0F, 3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-1.0F, -4.0F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }),
    POOLSUCKER("poolsucker", "Pool Sucker", "Lives on poolgunk.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-3.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 4).addBox(2.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(2.0F, -2.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 24).addBox(-3.0F, -2.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-2.0F, 2.0F, -4.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 15).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }),
    BRIMSTONE("brimstone", "Brimstone", "Gets its beautiful color from a coating of sulfur.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -6.0F, 2.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(1.0F, -4.0F, -6.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(15, 5).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(26, 19).addBox(-1.0F, -4.0F, 5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 22).addBox(-1.0F, -4.0F, -7.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-1.0F, -3.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(13, 22).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 2).addBox(1.5F, -2.25F, 3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(-2.5F, -2.25F, 3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.5F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -1.2217F, 0.0F, 0.0F));
        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 3).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.0F, -5.0F, -0.5236F, 0.0F, 0.0F));
        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.0F, -2.0F, -0.5236F, 0.0F, 0.0F));
        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 19).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.0F, 1.0F, -0.5236F, 0.0F, 0.0F));
        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(19, 6).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.0F, 4.0F, -0.5236F, 0.0F, 0.0F));
        PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(15, 0).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.5F, 1.0F, 0.0F, 0.0F, -0.48F));
        PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(13, 19).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.5F, 1.0F, 0.0F, 0.0F, 0.48F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }),
    DRIMP("drimp", "Drimp", "A sought after beautiful decorative fish.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(14, 0).addBox(1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(12, 11).addBox(-2.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(0.5F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 0).addBox(-1.5F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-1.5F, -2.0F, -3.5F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -1.25F, -0.25F, 0.7854F, 0.0F, 0.0F));
        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 5.75F, 0.7854F, 0.0F, 0.0F));
        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 20).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 5.5F, 0.0F, 0.3491F, 0.0F));
        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(22, 9).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 5.5F, 0.0F, -0.3491F, 0.0F));
        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.0F, 0.0F, 0.0F, -0.8727F, 0.0F));
        PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(8, 20).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.0F, 0.0F, 0.0F, 0.8727F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }),
    GLOOMOID("gloomoid", "Gloomoid", "Consumes sin.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-3.0F, -3.5F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(1.0F, -3.5F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(-0.5F, -3.25F, 2.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 2).addBox(-0.5F, -5.0F, 2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-0.5F, -6.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 18).addBox(-0.5F, -3.75F, -6.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 12).addBox(-0.5F, -3.75F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(0.25F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-1.25F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.25F, 2.5F, -0.5236F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }),
    SMALLMAN("smallman", "Smallman", "Tricky to catch. Considered a delicacy but contains carcinogens.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-4.0F, -4.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-4.0F, -1.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(4.0F, -2.75F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 9).addBox(-4.5F, -2.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 8).addBox(-4.5F, -2.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }),
    BIGMAN("bigman", "Bigman", "", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -6.0F, 5.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(13, 15).addBox(-3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(24, 33).addBox(-2.0F, -3.0F, -7.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(3.0F, -4.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -4.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 0).addBox(-1.0F, -5.0F, -4.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(13, 32).addBox(-1.0F, -3.0F, -12.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 23).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0F, -10.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 27).addBox(-2.5F, -0.5F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0774F, -0.8965F, -1.0F, 0.0F, 0.0F, 0.3491F));
        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 28).addBox(-4.0F, -2.0F, -3.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));
        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.5F, 1.0F, -0.4363F, 0.0F, 0.0F));
        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(26, 9).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.5F, -2.5F, -0.4363F, 0.0F, 0.0F));
        PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(26, 16).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.5F, -6.0F, -0.4363F, 0.0F, 0.0F));
        PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4814F, -2.5F, 4.9217F, 0.0F, -0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }),
    FISH("fish", "Fish", "The platonic ideal of a fish.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(7, 10).addBox(0.0F, -3.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 10).addBox(-2.0F, -3.0F, -4.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -3.0F, -8.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).addBox(-1.0F, -5.75F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).addBox(1.0F, -4.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 11).addBox(-3.0F, -4.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-2.0F, -3.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 10).addBox(-1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(14, 10).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, -1.5F, 0.25F, 0.0F, 0.6545F, 0.0F));
        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -1.5F, 0.25F, 0.0F, -0.6545F, 0.0F));
        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(15, 17).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.5F, 0.0F, 0.0F, 0.0F, 0.48F));
        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(6, 20).addBox(-0.5F, -1.0F, -2.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.5F, 0.0F, 0.0F, -0.48F));
        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -6.0F, 0.3491F, 0.0F, 0.0F));
        PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(7, 12).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0F, -6.0F, -0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }),
    NIGHTFREAK("nightfreak", "Nightfreak", "Emerges from the depths at night. The reflection you see in its eyes is not you.", () -> {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(13, 12).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-0.5F, -2.0F, -8.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 5).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, -0.5672F, 0.0F, 0.0F));
        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, -1.5F, -0.5672F, 0.0F, 0.0F));
        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -0.5F, 0.48F, 0.0F, 0.0F));
        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(17, 0).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -5.25F, -0.5672F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    });
//        ZOOPER("zooper", "Zooper", "Zoopers follow container ships and make strange noises.", () -> {}),
//        CARABINO("carabino", "Carabino", "A deranged combatant beyond help.", () -> {}),
//        MOONFISH("moonfish", "Moonfish", "A beautiful fish known for its use in chemical weapons.", () -> {}),
//        EEL("eel", "Eel", "Snakelike slippery fish that loves the rain.", () -> {}),
//        FLOUNDER("flounder", "Flounder", "Deformed by sin. A cowardly fish.", () -> {}),
//        GIGAFLOUNDER("gigaflounder", "Gigaflounder", "Deformed by power. A wrathful fish.", () -> {}),
//        BLURPO("blurpo", "Blurpo", "Blurpo is the smelliest saltwater fish on the market, an acquired taste.", () -> {}),
//        HYDRA("hydra", "Hydra", "God among fish.", () -> {}),
//        PSYCHOFISH("psychofish", "Psychofish", "Saps the psychic energies of nearby humans.", () -> {}),
//        BOUNCY_CASTLE("bouncy_castle", "Bouncy Castle", "This fish has come into contact with an experimental super-androgen.", () -> {}),
//        UNIDOR("unidor", "Unidor", "Rare tropical fish with many uses in the biotech industry.", () -> {}),
//        NOCTER("nocter", "Nocter", "Tropical fish drawn to the energy of high frequency commercial transactions.", () -> {}),
//        HUMAN("human", "Human", "Strange fish covered in shiny black plastic. Smells pretty bad.", () -> {}),
//        BUBBLEFISH("bubblefish", "Bubblefish", "Not prepared properly has a high chance of causing a stomach ulcer. Very cute, please put it back.", () -> {}),
//        FRAGFISH("fragfish", "Fragfish", "Explodes into high speed metal fragments when threatened. Can puncture a ship's hull easily.", () -> {}),
//        FLIPPY("flippy", "Flippy", "Common tropical fish. Collective intelligence, launches suicide assaults on ship engines.", () -> {}),
//        SKIPPY("skippy", "Skippy", "Rotates its disk-like body to skip across water.", () -> {}),
//        GRABSHARK("grabshark", "Grabshark", "Pressurizes swimmers by dragging them to the bottom of the ocean.", () -> {}),
//        DOLPHIN("dolphin", "Dolphin", "Said to be the result of human ichthyosation", () -> {}),
//        OCTOSAUR("octosaur", "Octosaur", "Loves drowning divers by releasing a cloud of acid.", () -> {}),
//        HEXASAUR("hexasaur", "Hexasaur", "Holds absolute power over octosaurs", () -> {}),
//        SLURPER("slurper", "Slurper", "Come on that's disgusting. Who would want that?", () -> {}),
//        PIPER("piper", "Piper", "Makes the sound of water rushing through plumbing.", () -> {}),
//        BOGDO("bogdo", "Bogdo", "Emerges from the deep in the swamp and makes disgusting grunting sounds. Eats corpses.", () -> {}),
//        SUPER_BOGDO("super_bogdo", "Super Bogdo", "A terrifying scream reverberates over the swamplands. It's Super Bogdo. Eats bogdos.", () -> {}),
//        SWAMPSUCKER("swampsucker", "Swampsucker", "Unlike the benign poolsucker, this one only eats human flesh.", () -> {}),
//        SPIKER("spiker", "Spiker", "The spikes are hard enough to go through protective steel plates. Popular as a booby trap.", () -> {}),
//        GUNK_EEL("gunk_eel", "Gunk Eel", "Covered in thick odorous hallucinogenic paste.", () -> {}),
//        LUCKSUCKER("lucksucker", "Lucksucker", "A pulsating, writhing sensation fills your head. Feeds on luck and shits out misforture.", () -> {}),
//        BONBO("bonbo", "Bonbo", "Sewage network traveler. Smiles at you and winks.", () -> {}),
//        FISH_OF_WEALTH("fish_of_wealth", "Fish of Wealth", "Considered a symbol of good wealth. Not worth much though.", () -> {}),
//        COINY("coiny", "coiny", "Avoids predators by hiding among coins.", () -> {}),
//        WHEEL_OF_FORTURE("wheel_of_forture", "Wheel of Fortune", "A sign of demonic luck.", () -> {}),
//        WHEEL_OF_PAIN("wheel_of_pain", "Wheel of Pain", "A sign of celestial punishment.", () -> {}),
//        ZIPPY_3000("zippy_3000", "Zippy 3000 (Broken)", "So close.", () -> {}),
//        AGON("agon", "Agon", "The sleeper.", () -> {}),
//        BOROION("boroion", "Boroion", "A primordial being.", () -> {}),
//        CREEP("creep", "Creep", "It won't leave you alone.", () -> {}),
//        DELTAFORCE("deltaforce", "Deltaforce", "A celestial aggressor.", () -> {}),
//        ETERNITY_SLURPER("eternity_slurper", "Eternity Slurper", "A primitive subterranean form of the slurper.", () -> {}),
//        DOSFISH("dosfish", "DOSfish", "Ancient machine that radiates knowledge attained by a legendary fishing expert.", () -> {}),
//        MISTAKE("mistake", "Mistake", "Sometimes things just go wrong.", () -> {}),
//        SUCCESS("success", "Success", "Now that's what I'm talking about.", () -> {}),
//        SUNFISH("sunfish", "Sunfish", "Went extinct in the 20th century.", () -> {}),
//        CUBERT("cubert", "Cubert", "Some king of speculative biology leaking from [REDACTED]'s head", () -> {}),
//        GLURM("glurm", "Glurm", "Thrives in complete darkness.", () -> {}),
//        DARKFISH("darkfish", "Darkfish", "This fish is malignant narcissist.", () -> {}),
//        DARKSLURPER("darkslurper", "Darkslurper", "Contains fissile material. Victim of overfishing.", () -> {}),
//        DARKSUCKER("darksucker", "Darksucker", "Darkness makes suckers slow and dull.", () -> {}),
//        ICEFISH("icefish", "Icefish", "A fish perfectly adapted to sub-zero temperatures.", () -> {}),
//        ICE_CUBERT("ice_cubert", "Ice Cubert", "It's body temperature is almost 0 kelvin.", () -> {}),
//        BLOSSOM("blossom", "Blossom", "Fills your mind with happy thoughts.", () -> {}),
//        CHTHONNER("chthonner", "Chthonner", "A transnistrian cave dweller. Herbivore.", () -> {}),
//        HEAD("head", "Head", "Someone's head infected with an extraterrestrial parasite.", () -> {}),
//        PONDMAN("pondman", "Pondman", "Reminds you of a friend long gone.", () -> {}),
//        HELIPOD("helipod", "Helipod", "As it spends the days flying around eating small insects, it's usually only caught at night.", () -> {}),
//        ENGINE_OF_CHAOS("engine_of_chaos", "Engine of Chaos", "Whirrs and gyrates with terrifying force as you try to make sense of your life.", () -> {}),
//        DEAD_FISH("dead_fish", "Dead Fish", "Animated by regret.", () -> {}),
//        TRANCER("trancer", "Trancer", "Mutated by malignant soundwaves and research chemicals", () -> {}),
//        FUZZOID("fuzzoid", "Fuzzoid", "Exists in boundaries, limits, edges. Primitive killer.", () -> {}),
//        SOUL("soul", "Soul", "You caught a soul. It feels sticky to touch.", () -> {});

    private final String name;
    private final String displayName;
    private final String description;
    private final LayerDefinition layerDefinition;

    private RegistryObject<EntityType<? extends FishEntity>> entityObject;
    private final ModelLayerLocation layer;
    private final ResourceLocation texture;


    Fishes(String name, String displayName, String description, NoArg<LayerDefinition> layerDefinition) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.layerDefinition = layerDefinition.apply();

        this.layer = new ModelLayerLocation(new ResourceLocation(CruelFishingMod.MODID, name), "main");
        this.texture = new ResourceLocation(CruelFishingMod.MODID, "textures/entities/" + name + ".png");
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public LayerDefinition getLayerDefinition() {
        return layerDefinition;
    }

    public RegistryObject<EntityType<? extends FishEntity>> getEntityObject() {
        return entityObject;
    }

    public void setEntityObject(RegistryObject<EntityType<? extends FishEntity>> newEntityObject) {
        entityObject = newEntityObject;
    }

    public ModelLayerLocation getLayer() {
        return layer;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public interface NoArg<T> {
        T apply();
    }
}
