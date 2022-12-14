package com.igorstan.cruelfishing.init;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(CruelFishingMod.MODID)
public class CruelFluids {

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.CORRUPTED_WATER_FLUID)
    public static final FlowingFluid CORRUPTED_WATER_FLUID = null;

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.CORRUPTED_WATER_FLOWING)
    public static final FlowingFluid CORRUPTED_WATER_FLOWING = null;

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.DEMONIC_BROTH_FLUID)
    public static final FlowingFluid DEMONIC_BROTH_FLUID = null;

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.DEMONIC_BROTH_FLOWING)
    public static final FlowingFluid DEMONIC_BROTH_FLOWING = null;

}
