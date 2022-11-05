package com.igorstan.cruelfishing.container;

import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.entity.player.PlayerInventory;
        import net.minecraft.inventory.container.Container;
        import net.minecraft.inventory.container.INamedContainerProvider;
        import net.minecraft.util.text.ITextComponent;
        import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StockMarketTabletProvider implements INamedContainerProvider {
    private final String displayName;

    public StockMarketTabletProvider(String displayName) {
        this.displayName = displayName;
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(displayName);
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity player) {
        return new StockMarketTabletContainer(i, playerInventory, player);
    }
}