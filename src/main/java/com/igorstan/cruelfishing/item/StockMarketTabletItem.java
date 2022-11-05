package com.igorstan.cruelfishing.item;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.container.StockMarketTabletCapabilityProvider;
import com.igorstan.cruelfishing.container.StockMarketTabletProvider;
import com.igorstan.cruelfishing.playerdata.IStockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarketCapabilityProvider;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
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
            IStockMarket iStockMarket = player.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
            System.out.println(iStockMarket.getFishAmount(RegistryNames.FLESHRAT_FISH));
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

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return new StockMarketTabletCapabilityProvider(stack, nslots);
    }

    @Nullable
    public static ItemStackHandler getInventory(ItemStack bag) {
        if (bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent())
            return (ItemStackHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).resolve().get();
        return null;
    }
    @Nonnull
    @Override
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity entity) {
        if (!(entity instanceof PlayerEntity)) {
            return stack;
        }

        PlayerEntity player = (PlayerEntity) entity;
        ItemStackHandler handler = getInventory(stack);
        if (handler == null) {
            return stack;
        }

        ItemStack bestFood = handler.getStackInSlot(0);
        if (bestFood.isFood() && !bestFood.isEmpty()) {
            ItemStack result = bestFood.onItemUseFinish(world, entity);
            // put bowls/bottles etc. into player inventory
            if (!result.isFood()) {
                handler.setStackInSlot(0, ItemStack.EMPTY);
                PlayerEntity playerEntity = (PlayerEntity) entity;

                if (!playerEntity.inventory.addItemStackToInventory(result)) {
                    playerEntity.dropItem(result, false);
                }
            }

        }

        return stack;
    }

}