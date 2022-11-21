package com.igorstan.cruelfishing.container;


import com.igorstan.cruelfishing.client.ClientContainerRegistry;
import com.igorstan.cruelfishing.item.StockMarketTabletItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class StockMarketTabletContainer extends Container {


    public ItemStack containerItem;


    private PlayerEntity playerEntity;

    public StockMarketTabletContainer(int id, PlayerEntity player) {
        super(ClientContainerRegistry.stockMarketTabletContainerContainerType, id);
        if (player.getHeldItemMainhand().getItem() instanceof StockMarketTabletItem) {
            containerItem = player.getHeldItemMainhand();
        }
        this.playerEntity = player;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}