package com.igorstan.cruelfishing;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup CRUEL_GROUP = new ItemGroup("cruelModsTab") {
        @Override
        public ItemStack createIcon() {
            return null;
        }
    };

}
