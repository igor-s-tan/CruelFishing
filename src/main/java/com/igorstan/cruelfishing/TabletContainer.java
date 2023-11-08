package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.registry.CruelContainers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class TabletContainer extends AbstractContainerMenu {


    public TabletContainer(int pContainerId, Inventory playerInv, FriendlyByteBuf extraData) {
        super(CruelContainers.TABLET_CONTAINER.get(), pContainerId);

    }
    public TabletContainer(int pContainerId, Inventory playerInv) {
        super(CruelContainers.TABLET_CONTAINER.get(), pContainerId);

    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }
}
