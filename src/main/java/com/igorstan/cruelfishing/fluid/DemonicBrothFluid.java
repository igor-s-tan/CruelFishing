package com.igorstan.cruelfishing.fluid;

import com.igorstan.cruelfishing.init.CruelBlocks;
import com.igorstan.cruelfishing.init.CruelFluids;
import com.igorstan.cruelfishing.init.CruelItems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class DemonicBrothFluid extends ForgeFlowingFluid {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(
            () -> CruelFluids.DEMONIC_BROTH_FLUID,
            () -> CruelFluids.DEMONIC_BROTH_FLOWING,
            FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
                    .density(15)
                    .luminosity(0)
                    .viscosity(35)
                    .sound(SoundEvents.BLOCK_WATER_AMBIENT)
                    .overlay(WATER_OVERLAY_RL)
                    .color(0xFFFF00FF))
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .tickRate(10)
            .block(() -> CruelBlocks.DEMONIC_BROTH_BLOCK)
            .bucket(() -> CruelItems.DEMONIC_BROTH_BUCKET);



    protected DemonicBrothFluid(Properties properties) {
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
