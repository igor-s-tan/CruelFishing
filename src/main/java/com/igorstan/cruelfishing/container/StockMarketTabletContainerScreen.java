package com.igorstan.cruelfishing.container;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.CapabilityItemHandler;

public class StockMarketTabletContainerScreen extends ContainerScreen<StockMarketTabletContainer>{
    public StockMarketTabletContainerScreen(StockMarketTabletContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrices, float partialTicks, int x, int y) {
        this.drawBackground(matrices, new ResourceLocation(CruelFishingMod.MODID, "textures/gui/inventory.png"));
        this.container.containerItem.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
            int slotsPerRow = h.getSlots();
            if (h.getSlots() > 9) {
                slotsPerRow = h.getSlots() / 2;
            }
            int xStart = (2*8 + 9*18 - slotsPerRow * 18) / 2;
            int yStart = 17 + 18;
            if (h.getSlots() > 9) {
                yStart = 17 + (84-36-23)/2;
            }
            for (int i = 0; i < h.getSlots(); i++) {
                int row = i / slotsPerRow;
                int col = i % slotsPerRow;
                int xPos = xStart - 1 + col * 18;
                int yPos = yStart - 1 + row * 18;

                this.drawSlot(matrices, xPos, yPos);
            }
        });
    }

    protected void drawBackground(MatrixStack ms, ResourceLocation gui) {
        this.minecraft.getTextureManager().bindTexture(gui);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(ms, relX, relY, 0, 0, this.xSize, this.ySize);
    }

    protected void drawSlot(MatrixStack ms, int x, int y, ResourceLocation texture, int size) {
        this.minecraft.getTextureManager().bindTexture(texture);
        blit(ms, guiLeft + x, guiTop + y, 0, 0, size, size, size, size);
    }

    protected void drawSlot(MatrixStack ms, int x, int y) {
        drawSlot(ms, x, y, new ResourceLocation(CruelFishingMod.MODID, "textures/gui/slot.png"), 18);
    }
}
