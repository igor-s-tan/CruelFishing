package com.igorstan.cruelfishing.client.screen;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.CruelResourses;
import com.igorstan.cruelfishing.capability.PortfolioCapability;
import com.igorstan.cruelfishing.capability.StocksInfoCapability;
import com.igorstan.cruelfishing.client.container.TabletContainer;
import com.igorstan.cruelfishing.entity.FishEntity;
import com.igorstan.cruelfishing.network.BuyFishPacket;
import com.igorstan.cruelfishing.network.CruelNetworking;
import com.igorstan.cruelfishing.registry.CruelEntities;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import org.joml.*;

import javax.annotation.Nullable;
import java.awt.*;
import java.lang.Math;
import java.util.Collections;
import java.util.Vector;

public class TabletScreen extends EffectRenderingInventoryScreen<TabletContainer> {

    public static final ResourceLocation GUI = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/tablet_screen.png");
    public static final ResourceLocation FISH_NAME = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/fish_name.png");

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
    private static EntityType<? extends FishEntity> displayedFish;
    private int relX, relY;

    public TabletScreen(TabletContainer pContainer, Inventory pPlayerInventory, Component pTitle) {
        super(pContainer, pPlayerInventory, pTitle);
        int shift = (int) Math.pow(10, 10);
        inventoryLabelX += shift;
        inventoryLabelY += shift;
        titleLabelX += shift;
        titleLabelY += shift;
        walker = 0.0f;
        relX = (this.width - backWidth) / 2;
        relY = (this.height - backHeight) / 2;
    }

    @Override
    protected void init() {
        super.init();
        relX = (this.width - backWidth) / 2;
        relY = (this.height - backHeight) / 2;
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


        ImageButton fleshrat = new ImageButton(relX + 5,relY + 5,57, 11, 0, 0, 0, FISH_NAME, 57, 11, (button) -> {
            displayedFish = CruelEntities.FLESHRAT_ENTITY.get();
        });

        this.addRenderableWidget(fleshrat);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        walker += 0.1f;
        if(walker >= 360f) {
            walker = 0f;
        }
        relX = (this.width - backWidth) / 2;
        relY = (this.height - backHeight) / 2;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {


        //this.renderBackground(pPoseStack);



        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);


    }

    private static void onAccept(Button button) {
        if(displayedFish != null) {
            CruelNetworking.INSTANCE.sendToServer(new BuyFishPacket(displayedFish.getDescriptionId(), Integer.valueOf(button.getMessage().getString())));
        }

    }


    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        //RenderSystem.setShaderTexture(0, GUI);
        GuiComponent.fill(pPoseStack, relX, relY, relX+backWidth, relY+backHeight, Color.BLACK.getRGB());


        GuiComponent.fill(pPoseStack, relX+(int)Math.floor(backWidth*0.3), relY, relX+(int)Math.floor(backWidth*0.3) + 1, relY+backHeight, Color.LIGHT_GRAY.getRGB());
        GuiComponent.fill(pPoseStack, relX+(int)Math.floor(backWidth*0.3), relY+(backHeight/2), relX+backWidth, relY+(backHeight/2)+1, Color.LIGHT_GRAY.getRGB());



        //GuiComponent.blit(pPoseStack, relX, relY, 0, 0, backWidth, backHeight);

        //Quaternionf quaternionf1 = (new Quaternionf()).rotateX((float)Math.PI);
        if(displayedFish != null) {
            renderFish(pPoseStack, pPartialTick, displayedFish);
            this.minecraft.level.getCapability(StocksInfoCapability.STOCKS_INFO).ifPresent(stocksInfo -> {
                Vector<Float> prices = stocksInfo.getPrices(displayedFish.getDescriptionId());
                float maxPrice = Collections.max(prices);
                drawString(pPoseStack, this.font, "Price: $" + prices.get(prices.size()-1), relX+2 + (int)Math.floor(backWidth*0.3), relY + 10, Color.WHITE.getRGB());
                int startX = relX+(int)Math.floor(backWidth*0.3) + 10;
                int startY = relY + backHeight/2 - 50;
                int endY = startY - 30;
                int time = ((int)Math.floor(backWidth*0.7) -20)/(CruelResourses.PRICE_HISTORY_SIZE-1);

                int count = 0;
                float prevPrice = prices.get(0);
                //prices.remove(0);
                for(Float price: prices) {
                    if(prices.indexOf(price) == 0) {continue;}
                    Color color;
                    float firstPoint = startY - (startY - endY)*(prevPrice/maxPrice);
                    float secondPoint = startY - (startY - endY)*(price/maxPrice);
                    if(firstPoint < secondPoint) {
                        color = Color.RED;
                    } else {
                        color = Color.GREEN;
                    }
                    drawDiagonalLine(pPoseStack, startX + count*time, (int)Math.floor(firstPoint), startX + (count+1)*time, (int)Math.floor(secondPoint), color.getRGB());
                    prevPrice = price;
                    ++count;
                }
            });
        }
        //pEntity.yBodyRot = walker;



        drawString(pPoseStack, this.font, "FLSH", relX + 7, relY + 7, Color.WHITE.getRGB());


        this.minecraft.player.getCapability(PortfolioCapability.PORTFOLIO).ifPresent(portfolio -> {
            drawString(pPoseStack, this.font, "Cash: $" + portfolio.getNetWorth(), relX+2 + (int)Math.floor(backWidth*0.3), relY+2, Color.WHITE.getRGB());
        });






    }

    private void renderFish(PoseStack pPoseStack, float pPartialTick, EntityType<? extends FishEntity> entityType) {
        FishEntity pEntity = entityType.create(this.minecraft.level);
        Quaternionf quaternionf = (new Quaternionf()).rotateZ((float)Math.PI);
        pEntity.setYRot(walker);
        renderEntity(pPoseStack, relX + backWidth - 91, this.topPos + 75, 60, quaternionf, quaternionf, pEntity);
    }



    @Override
    protected void renderLabels(PoseStack pose, int mouseX, int mouseY) {
        super.renderLabels(pose, mouseX, mouseY);
        // Assume we have some Component 'label'
        // 'label' is drawn at 'labelX' and 'labelY'
        // this.font.draw(pose, label, labelX, labelY, 0x404040);
    }


    private void drawDiagonalLine(PoseStack pPoseStack, int x0, int y0, int x1, int y1, int color) {
        int y_prev = 0;
        for(int i = 0; i < x1 - x0; ++i) {
            double y = (i+1)*(y1-y0+0.0)/(x1-x0+0.0) + y0;
            if(y < y0) {
                y = Math.floor(y);
            } else {
                y = Math.ceil(y);
            }
            drawPixel(pPoseStack, x0 + i, (int) y, color);
            for(int k = 1; k < y_prev - (int)y; ++k) {
                drawPixel(pPoseStack, x0 + i, (int) y+k, color);
            }
            y_prev = (int)y;
        }
    }

    private void drawPixel(PoseStack pPoseStack, int x0, int y0, int color) {
        fill(pPoseStack, x0, y0, x0+1, y0+1, color);
    }

    private void renderEntity(PoseStack pPoseStack, int pX, int pY, int pScale, Quaternionf p_275229_, @Nullable Quaternionf pCameraOrientation, LivingEntity pEntity) {
        double d0 = 1000.0D;
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.pushPose();
        posestack.translate(0.0D, 0.0D, 1000.0D);
        RenderSystem.applyModelViewMatrix();
        pPoseStack.pushPose();
        pPoseStack.translate((double)pX, (double)pY+55, -950.0D);
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
            entityrenderdispatcher.render(pEntity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, pPoseStack, multibuffersource$buffersource, 7864440);
        });
        multibuffersource$buffersource.endBatch();
        entityrenderdispatcher.setRenderShadow(true);
        pPoseStack.popPose();
        Lighting.setupFor3DItems();
        posestack.popPose();
        RenderSystem.applyModelViewMatrix();
    }


}
