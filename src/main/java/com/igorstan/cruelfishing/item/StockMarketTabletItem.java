package com.igorstan.cruelfishing.item;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.container.StockMarketTabletProvider;
import com.igorstan.cruelfishing.container.StockMarketTabletScreen;
import com.igorstan.cruelfishing.playerdata.IStockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarketCapabilityProvider;
import com.igorstan.cruelfishing.playerdata.StockMarketStorage;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StockMarketTabletItem extends Item {
    private final String displayName;
    private final int nslots;

    public StockMarketTabletItem(int nslots, String displayName) {
        super(new Properties().group(CruelFishingMod.CRUEL_GROUP).maxStackSize(1).setNoRepair());
        this.displayName = displayName;
        this.nslots = nslots;
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (!world.isRemote) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new StockMarketTabletProvider(displayName), player.getPosition());
        }
        return ActionResult.resultPass(player.getHeldItem(hand));
    }

//    private ActionResult<ItemStack> processRightClick(World world, PlayerEntity player, Hand hand) {
//        ItemStack stack = player.getHeldItem(hand);
//        if (isInventoryEmpty(stack)) {
//            return ActionResult.resultPass(stack);
//        }
//
//        if (player.canEat(false)) {
//            player.setActiveHand(hand);
//            return ActionResult.resultConsume(stack);
//        }
//        return ActionResult.resultFail(stack);
//    }

//    private static boolean isInventoryEmpty(ItemStack container) {
//        ItemStackHandler handler = getInventory(container);
//        if (handler == null) {
//            return true;
//        }
//
//        for (int i = 0; i < handler.getSlots(); i++) {
//            ItemStack stack = handler.getStackInSlot(i);
//            if (!stack.isEmpty() && stack.isFood()) {
//                return false;
//            }
//        }
//        return true;
//    }



}