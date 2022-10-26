package com.igorstan.cruelfishing.init;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.item.FiberglassFishingRodItem;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(CruelFishingMod.MODID)
public class CruelItems {

    public static final Item FIBERGLASS_FISHING_ROD =
            register(new FiberglassFishingRodItem(new Item.Properties().defaultMaxDamage(128).group(CruelFishingMod.CRUEL_GROUP)), RegistryNames.FIBERGLASS_FISHING_ROD);


    public static final Item CORRUPTED_WATER_BUCKET =
            register(new BucketItem(() -> CruelFluids.CORRUPTED_WATER_FLUID, new Item.Properties().maxStackSize(1).group(CruelFishingMod.CRUEL_GROUP)), RegistryNames.CORRUPTED_WATER_BUCKET);


    public static final Item FLESHRAT_FISH =
            register(new Item(new Item.Properties().group(CruelFishingMod.CRUEL_GROUP)), RegistryNames.FLESHRAT_FISH);


    public static Item register(@Nonnull Item item, @Nonnull String name) {
        return register(item, new ResourceLocation(CruelFishingMod.MODID, name));
    }

    public static Item register(@Nonnull Item item, @Nonnull ResourceLocation registryName) {
        item.setRegistryName(registryName);
        return item;
    }
}

