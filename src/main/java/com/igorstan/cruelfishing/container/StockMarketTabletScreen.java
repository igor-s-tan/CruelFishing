package com.igorstan.cruelfishing.container;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class StockMarketTabletScreen extends ContainerScreen<StockMarketTabletContainer>{

    public static final ResourceLocation BUY_BUTTON_TEXTURE = new ResourceLocation(CruelFishingMod.MODID, "textures/gui/buy_button.png");
    public static final int backWidth = 256;
    public static final int backHeight = 225;

    public StockMarketTabletScreen(StockMarketTabletContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
        this.playerInventoryTitleX = -1000;
        this.playerInventoryTitleY = -1000;
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(ms, mouseX, mouseY);

//        this.addButton(new ImageButton())


    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrices, float partialTicks, int x, int y) {
        this.drawBackground(matrices, new ResourceLocation(CruelFishingMod.MODID, "textures/gui/background.png"));
        int relX = (this.width - backWidth) / 2;
        int relY = (this.height - backHeight) / 2;
        this.addButton(new Button(relX+88, relY+181, 37, 17, new TranslationTextComponent("Buy"), (p_213070_1_) -> {

        }));
        this.addButton(new Button(relX+6, relY+6, 69, 10, new TranslationTextComponent("Fleshrat"), (p_213070_1_) -> {

        }));
    }

    protected void drawBackground(MatrixStack ms, ResourceLocation gui) {
        this.minecraft.getTextureManager().bindTexture(gui);
        int relX = (this.width - backWidth) / 2;
        int relY = (this.height - backHeight) / 2;
        this.blit(ms, relX, relY, 0, 0, backWidth, backHeight);
    }
}
