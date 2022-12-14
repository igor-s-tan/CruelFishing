package com.igorstan.cruelfishing.block;

import com.igorstan.cruelfishing.fluid.DemonicBrothFluid;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DemonicBrothBlock extends FlowingFluidBlock {
    public DemonicBrothBlock() {
        super(DemonicBrothFluid.Source::new, Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops());
    }

    @Override
    public void onEntityCollision(BlockState blockState, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity && ((LivingEntity) entityIn).getActivePotionEffects().isEmpty()) {
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.GLOWING, 60, 0));
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
