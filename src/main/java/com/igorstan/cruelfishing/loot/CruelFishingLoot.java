package com.igorstan.cruelfishing.loot;

import com.igorstan.cruelfishing.CruelFishingMod;
import net.minecraft.util.ResourceLocation;


public class CruelFishingLoot {

    public static final ResourceLocation CRUEL_FISHING = create("gameplay/cruel_fishing");

    private static ResourceLocation create(String path) {
        return new ResourceLocation(CruelFishingMod.MODID, path);
    }
}