package com.igorstan.cruelfishing.fluid;

import com.igorstan.cruelfishing.init.CruelBlocks;
import com.igorstan.cruelfishing.init.CruelFluids;
import com.igorstan.cruelfishing.init.CruelItems;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class CorruptedWaterFluid extends ForgeFlowingFluid {

    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");
    public static final ResourceLocation LAVA_OVERLAY_RL = new ResourceLocation("block/lava_overlay");

    public static final ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(
            () -> CruelFluids.CORRUPTED_WATER_FLUID,
            () -> CruelFluids.CORRUPTED_WATER_FLOWING,
            FluidAttributes.builder(LAVA_STILL_RL, LAVA_FLOWING_RL)
                    .density(15)
                    .luminosity(0)
                    .viscosity(35)
                    .sound(SoundEvents.BLOCK_LAVA_AMBIENT)
                    .overlay(LAVA_OVERLAY_RL)
                    .color(0xFF00FF00))
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .tickRate(10)
            .block(() -> CruelBlocks.CORRUPTED_WATER_BLOCK)
            .bucket(() -> CruelItems.CORRUPTED_WATER_BUCKET);



    protected CorruptedWaterFluid(Properties properties) {
        super(properties);
    }

    public static class Flowing extends ForgeFlowingFluid.Flowing {
        public Flowing() {
            super(properties);
        }
    }

    public static class Source extends ForgeFlowingFluid.Source {
        public Source() {
            super(properties);
        }
    }


}
