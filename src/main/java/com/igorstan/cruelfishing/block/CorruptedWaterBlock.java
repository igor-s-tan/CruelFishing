package com.igorstan.cruelfishing.block;

import com.igorstan.cruelfishing.fluid.CorruptedWaterFluid;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CorruptedWaterBlock extends FlowingFluidBlock {

    public CorruptedWaterBlock() {
        super(CorruptedWaterFluid.Source::new, Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops());
    }

    @Override
    public void onEntityCollision(BlockState blockState, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity && ((LivingEntity) entityIn).getActivePotionEffects().isEmpty()) {
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 60, 0));
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
