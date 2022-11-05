package com.igorstan.cruelfishing.item;

import com.igorstan.cruelfishing.CruelFishingMod;
import net.minecraft.item.Item;

public class FishItem extends Item {

    public String description;

    public FishItem(Properties properties, String description) {
        super(properties.maxStackSize(1).group(CruelFishingMod.CRUEL_GROUP));
        this.description = description;
    }

    public String getFishDescription() {
        return description;
    }
}
