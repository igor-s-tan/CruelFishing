package com.igorstan.cruelfishing;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class Fluids {

    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");
    public static final ResourceLocation LAVA_OVERLAY_RL = new ResourceLocation("block/lava_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, CruelFishingMod.MODID);

    public static final RegistryObject<FlowingFluid> OIL_FLUID
            = FLUIDS.register("oil_fluid", () -> new ForgeFlowingFluid.Source(Fluids.OIL_PROPERTIES));

    public static final RegistryObject<FlowingFluid> OIL_FLOWING
            = FLUIDS.register("oil_flowing", () -> new ForgeFlowingFluid.Flowing(Fluids.OIL_PROPERTIES));


    public static final ForgeFlowingFluid.Properties OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> OIL_FLUID.get(), () -> OIL_FLOWING.get(), FluidAttributes.builder(LAVA_STILL_RL, LAVA_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.BLOCK_WATER_AMBIENT).overlay(LAVA_OVERLAY_RL)
            .color(0xFF5A228B)).slopeFindDistance(2).tickRate(30).levelDecreasePerBlock(2)
            .block(() -> Fluids.OIL_BLOCK.get()).bucket(() -> Items.OIL_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> OIL_BLOCK = Blocks.BLOCKS.register("oil",
            () -> new FlowingFluidBlock(() -> Fluids.OIL_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .hardnessAndResistance(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
