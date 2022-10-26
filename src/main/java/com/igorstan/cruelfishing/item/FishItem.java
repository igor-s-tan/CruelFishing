package com.igorstan.cruelfishing.item;

import net.minecraft.item.Item;

public class FishItem extends Item {

    public String description;

    public FishItem(Properties properties, String description) {
        super(properties);
        this.description = description;
    }

    public String getFishDescription() {
        return description;
    }
}
