package com.igorstan.cruelfishing;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class TabletScreen extends AbstractContainerScreen<TabletContainer> {

    public static final ResourceLocation GUI = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/tablet_screen.png");
    public static final ResourceLocation BUY_BUTTON = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_button.png");

    public static final int backWidth = 256;
    public static final int backHeight = 225;

    public TabletScreen(TabletContainer pContainer, Inventory pPlayerInventory, Component pTitle) {
        super(pContainer, pPlayerInventory, pTitle);
        int shift = (int) Math.pow(10, 10);
        inventoryLabelX += shift;
        inventoryLabelY += shift;
        titleLabelX += shift;
        titleLabelY += shift;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        int relX = (this.width - backWidth) / 2;
        int relY = (this.height - backHeight) / 2;
        this.renderBackground(pPoseStack);

        this.addRenderableWidget(new ImageButton(relX + 18, relY + 20, 30, 16, 0, 0, 0, BUY_BUTTON, 30, 16, TabletScreen::onAccept));

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);




        this.renderTooltip(pPoseStack, pMouseX, pMouseY);


    }

    private static void onAccept(Button button) {

    }


    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - backWidth) / 2;
        int relY = (this.height - backHeight) / 2;
        GuiComponent.blit(pPoseStack, relX, relY, 0, 0, backWidth, backHeight);

    }


    private void renderFishModel(EntityModel<? extends FishEntity> model) {

    }

    @Override
    protected void renderLabels(PoseStack pose, int mouseX, int mouseY) {
        super.renderLabels(pose, mouseX, mouseY);

        // Assume we have some Component 'label'
        // 'label' is drawn at 'labelX' and 'labelY'
        // this.font.draw(pose, label, labelX, labelY, 0x404040);
    }


}
