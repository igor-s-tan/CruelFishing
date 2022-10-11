package com.igorstan.cruelfishing;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.FishRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import com.igorstan.cruelfishing.Items;


public class CruelFishingRenderer {
    public static void register() {
        RenderingRegistry.registerEntityRenderingHandler(Entities.FIBERGLASS_BOBBER, FishRenderer::new);
        ItemModelsProperties
                .registerProperty(RegistryHolder.FIBERGLASS_FISHING_ROD, new ResourceLocation("cast"),
                        (p_239422_0_, p_239422_1_, p_239422_2_) -> {
                            if (p_239422_2_ == null) {
                                return 0.0F;
                            } else {
                                boolean flag = p_239422_2_.getHeldItemMainhand() == p_239422_0_;
                                boolean flag1 = p_239422_2_.getHeldItemOffhand() == p_239422_0_;
                                if (p_239422_2_.getHeldItemMainhand().getItem() instanceof FishingRodItem) {
                                    flag1 = false;
                                }

                                return (flag || flag1) && p_239422_2_ instanceof PlayerEntity
                                        && ((PlayerEntity) p_239422_2_).fishingBobber != null ? 1.0F : 0.0F;
                            }
                        });
    }


}
