package com.igorstan.cruelfishing.init;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(CruelFishingMod.MODID)
public class CruelBlocks {

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.CORRUPTED_WATER_BLOCK)
    public static final FlowingFluidBlock CORRUPTED_WATER_BLOCK = null;

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.DEMONIC_BROTH_BLOCK)
    public static final FlowingFluidBlock DEMONIC_BROTH_BLOCK = null;
}
