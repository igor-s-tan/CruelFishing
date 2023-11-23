package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.models.FleshratFishModel;
import com.igorstan.cruelfishing.registry.CruelClientRegistry;
import com.igorstan.cruelfishing.registry.CruelEntities;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.network.NetworkHooks;
import org.joml.*;

import javax.annotation.Nullable;
import java.awt.*;
import java.lang.Math;

public class TabletScreen extends EffectRenderingInventoryScreen<TabletContainer> {

    public static final ResourceLocation GUI = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/tablet_screen.png");

    public static final ResourceLocation BUY_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_button.png");
    public static final ResourceLocation BUY_2_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_2_button.png");
    public static final ResourceLocation BUY_5_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_5_button.png");
    public static final ResourceLocation BUY_10_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_10_button.png");
    public static final ResourceLocation BUY_50_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_50_button.png");
    public static final ResourceLocation BUY_100_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_100_button.png");

    public static final ResourceLocation SELL_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/sell_button.png");
    public static final ResourceLocation SELL_2_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/sell_2_button.png");
    public static final ResourceLocation SELL_5_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/sell_5_button.png");
    public static final ResourceLocation SELL_10_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/sell_10_button.png");
    public static final ResourceLocation SELL_50_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/sell_50_button.png");
    public static final ResourceLocation SELL_100_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/sell_100_button.png");


    public static final int backWidth = 256;
    public static final int backHeight = 225;

    private float walker;

    public TabletScreen(TabletContainer pContainer, Inventory pPlayerInventory, Component pTitle) {
        super(pContainer, pPlayerInventory, pTitle);
        int shift = (int) Math.pow(10, 10);
        inventoryLabelX += shift;
        inventoryLabelY += shift;
        titleLabelX += shift;
        titleLabelY += shift;
        walker = 0.0f;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        int relX = (this.width - backWidth) / 2;
        int relY = (this.height - backHeight) / 2;

        this.renderBackground(pPoseStack);

        ImageButton buy = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5,           relY+(backHeight/2) + 5,                    31, 16, 0, 0, 0, BUY_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton buy2 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 31 + 3,  relY+(backHeight/2) + 5,                    31, 16, 0, 0, 0, BUY_2_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton buy5 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5,           relY+(backHeight/2) + 5 + 16 + 3,           31, 16, 0, 0, 0, BUY_5_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton buy10 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 31 + 3,  relY+(backHeight/2) + 5 + 16 + 3,           31, 16, 0, 0, 0, BUY_10_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton buy50 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5,           relY+(backHeight/2) + 5 + 16 + 3 + 16 + 3,  31, 16, 0, 0, 0, BUY_50_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton buy100 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 31 + 3,  relY+(backHeight/2) + 5 + 16 + 3 + 16 + 3,  31, 16, 0, 0, 0, BUY_100_BUTTON, 31, 16, TabletScreen::onAccept);

        buy.setMessage(Component.translatable("1"));
        buy2.setMessage(Component.translatable("2"));
        buy5.setMessage(Component.translatable("5"));
        buy10.setMessage(Component.translatable("10"));
        buy50.setMessage(Component.translatable("50"));
        buy100.setMessage(Component.translatable("100"));

        this.addRenderableWidget(buy);
        this.addRenderableWidget(buy2);
        this.addRenderableWidget(buy5);
        this.addRenderableWidget(buy10);
        this.addRenderableWidget(buy50);
        this.addRenderableWidget(buy100);

        ImageButton sell = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 80,           relY+(backHeight/2) + 5,                    31, 16, 0, 0, 0, SELL_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton sell2 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 31 + 3 + 80,  relY+(backHeight/2) + 5,                    31, 16, 0, 0, 0, SELL_2_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton sell5 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 80,           relY+(backHeight/2) + 5 + 16 + 3,           31, 16, 0, 0, 0, SELL_5_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton sell10 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 31 + 3 + 80,  relY+(backHeight/2) + 5 + 16 + 3,           31, 16, 0, 0, 0, SELL_10_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton sell50 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 80,           relY+(backHeight/2) + 5 + 16 + 3 + 16 + 3,  31, 16, 0, 0, 0, SELL_50_BUTTON, 31, 16, TabletScreen::onAccept);
        ImageButton sell100 = new ImageButton(relX+(int)Math.floor(backWidth*0.3) + 5 + 31 + 3 + 80,  relY+(backHeight/2) + 5 + 16 + 3 + 16 + 3,  31, 16, 0, 0, 0, SELL_100_BUTTON, 31, 16, TabletScreen::onAccept);

        sell.setMessage(Component.translatable("-1"));
        sell2.setMessage(Component.translatable("-2"));
        sell5.setMessage(Component.translatable("-5"));
        sell10.setMessage(Component.translatable("-10"));
        sell50.setMessage(Component.translatable("-50"));
        sell100.setMessage(Component.translatable("-100"));

        this.addRenderableWidget(sell);
        this.addRenderableWidget(sell2);
        this.addRenderableWidget(sell5);
        this.addRenderableWidget(sell10);
        this.addRenderableWidget(sell50);
        this.addRenderableWidget(sell100);

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);


    }

    private static void onAccept(Button button) {
        System.out.println(Integer.valueOf(button.getMessage().getString()));
    }


    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        //RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - backWidth) / 2;
        int relY = (this.height - backHeight) / 2;
        GuiComponent.fill(pPoseStack, relX, relY, relX+backWidth, relY+backHeight, Color.BLACK.getRGB());


        GuiComponent.fill(pPoseStack, relX+(int)Math.floor(backWidth*0.3), relY, relX+(int)Math.floor(backWidth*0.3) + 1, relY+backHeight, Color.LIGHT_GRAY.getRGB());
        GuiComponent.fill(pPoseStack, relX+(int)Math.floor(backWidth*0.3), relY+(backHeight/2), relX+backWidth, relY+(backHeight/2)+1, Color.LIGHT_GRAY.getRGB());



        //GuiComponent.blit(pPoseStack, relX, relY, 0, 0, backWidth, backHeight);
        Quaternionf quaternionf = (new Quaternionf()).rotateZ((float)Math.PI);
        //Quaternionf quaternionf1 = (new Quaternionf()).rotateX((float)Math.PI);
        FishEntity pEntity = CruelEntities.FLESHRAT.get().create(this.minecraft.level);
        //pEntity.yBodyRot = walker;

        drawDiagonalLine(pPoseStack, 7, 87, 15, 54, Color.GREEN.getRGB());
        drawDiagonalLine(pPoseStack, 15, 54, 90, 90, Color.RED.getRGB());

        pEntity.setYRot(walker);


        renderEntity(pPoseStack, relX + backWidth - 91, this.topPos + 75, 30, quaternionf, quaternionf, pEntity);

    }

    @Override
    protected void containerTick() {
        super.containerTick();
        walker += 0.1f;
        if(walker >= 360f) {
            walker = 0f;
        }
    }

    @Override
    protected void renderLabels(PoseStack pose, int mouseX, int mouseY) {
        super.renderLabels(pose, mouseX, mouseY);

        // Assume we have some Component 'label'
        // 'label' is drawn at 'labelX' and 'labelY'
        // this.font.draw(pose, label, labelX, labelY, 0x404040);
    }


    private void drawDiagonalLine(PoseStack pPoseStack, int x0, int y0, int x1, int y1, int color) {
        int hDist = Math.abs(x0 - x1);
        int vDist = Math.abs(y0 - y1);
        int parts = Math.min(hDist, vDist);

        if(parts == hDist) {
            int length = (int) Math.floor((float) (y1 - y0) / (float) parts);
            int residual = y1 - y0 - length*parts;
            for(int i = 0; i < parts; ++i) {
                fill(pPoseStack, x0 + i, y0 + length*i, x0 + i, y0 + length*(i+1), color);
            }
            fill(pPoseStack, x1, y1 - residual, x1, y1, color);
        } else {
            int length1 = (int) Math.floor((float) (x1 - x0) / (float) parts);
            int length2 = length1 + 1;

            Vector2f vec = new Vector2f(hDist, parts);
            Matrix2f mat = new Matrix2f();
            mat.m00 = length1;
            mat.m01 = length2;
            mat.m10 = 1;
            mat.m11 = 1;
            mat.invert();
            mat.transpose();
            Vector2f result = mat.transform(vec);
            int parts1 = (int) result.x;
            int parts2 = (int) result.y;
            for(int i = 0; i < parts1; ++i) {
                fill(pPoseStack, Math.min(x0 + length1*i, x0 + length1*(i+1)), y0 + i, Math.max(x0 + length1*i, x0 + length1*(i+1)), y0 + i + 1, color);
            }
            for(int i = 0; i < parts2; ++i) {
                int temp1 = x0 + length1 * parts1 + length2 * i;
                int temp2 = x0 + length1 * parts1 + length2 * (i + 1);
                fill(pPoseStack, Math.min(temp1, temp2), y0 + parts1 + i, Math.max(temp1, temp2), y0 + parts1 + i + 1, color);
            }

        }

    }

    private void renderEntity(PoseStack pPoseStack, int pX, int pY, int pScale, Quaternionf p_275229_, @Nullable Quaternionf pCameraOrientation, LivingEntity pEntity) {
        double d0 = 1000.0D;
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.pushPose();
        posestack.translate(0.0D, 0.0D, 1000.0D);
        RenderSystem.applyModelViewMatrix();
        pPoseStack.pushPose();
        pPoseStack.translate((double)pX, (double)pY, -950.0D);
        pPoseStack.mulPoseMatrix((new Matrix4f()).scaling((float)pScale, (float)pScale, (float)(-pScale)));
        pPoseStack.mulPose(p_275229_);
        Lighting.setupForEntityInInventory();
        EntityRenderDispatcher entityrenderdispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        if (pCameraOrientation != null) {
            pCameraOrientation.conjugate();
            entityrenderdispatcher.overrideCameraOrientation(pCameraOrientation);
        }

        entityrenderdispatcher.setRenderShadow(false);
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        RenderSystem.runAsFancy(() -> {
            entityrenderdispatcher.render(pEntity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, pPoseStack, multibuffersource$buffersource, 5242960);
        });
        multibuffersource$buffersource.endBatch();
        entityrenderdispatcher.setRenderShadow(true);
        pPoseStack.popPose();
        Lighting.setupFor3DItems();
        posestack.popPose();
        RenderSystem.applyModelViewMatrix();
    }


}
