package com.igorstan.cruelfishing;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(value = CruelFishingMod.MODID)
public class RegistryHolder {
    @ObjectHolder(RegistryReference.FIBERGLASS_FISHING_ROD)
    public static final Item FIBERGLASS_FISHING_ROD;

    static {
        FIBERGLASS_FISHING_ROD = null;
    }
}
