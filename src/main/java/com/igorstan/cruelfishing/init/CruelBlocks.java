package com.igorstan.cruelfishing.init;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.block.CorruptedWaterBlock;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
@ObjectHolder(CruelFishingMod.MODID)
public class CruelBlocks {

    @ObjectHolder(CruelFishingMod.MODID + ":" + RegistryNames.CORRUPTED_WATER_BLOCK)
    public static final FlowingFluidBlock CORRUPTED_WATER_BLOCK = null;

}
