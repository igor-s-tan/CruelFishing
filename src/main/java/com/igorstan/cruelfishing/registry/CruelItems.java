package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.CruelResourses;
import com.igorstan.cruelfishing.item.FiberglassFishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CruelItems {
    public static final DeferredRegister<Item> CRUEL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CruelFishingMod.MODID);
    public static final RegistryObject<Item> FIBERGLASS_FISHING_ROD = CRUEL_ITEMS.register(CruelResourses.cruelFiberglassFishingRodItem, () -> new FiberglassFishingRodItem(new Item.Properties().defaultDurability(128)));

}
