package com.igorstan.cruelfishing.client;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.container.StockMarketTabletContainer;
import com.igorstan.cruelfishing.init.CruelEntities;
import com.igorstan.cruelfishing.init.CruelItems;
import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.client.renderer.entity.FishRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ClientModelRenderer {

    public static void register() {
        RenderingRegistry.registerEntityRenderingHandler(CruelEntities.FIBERGLASS_BOBBER,
                FishRenderer::new);
        ItemModelsProperties.registerProperty(CruelItems.FIBERGLASS_FISHING_ROD, new ResourceLocation("cast"),
                (p_239422_0_, p_239422_1_, p_239422_2_) -> {
                    if (p_239422_2_ == null) {
                        return 0.0F;
                    } else {
                        boolean flag = p_239422_2_.getHeldItemMainhand() == p_239422_0_;
                        boolean flag1 = p_239422_2_.getHeldItemMainhand() == p_239422_0_;
                        if (p_239422_2_.getHeldItemMainhand().getItem() instanceof FishingRodItem) {
                            flag1 = false;
                        }

                        return (flag || flag1) && p_239422_2_ instanceof PlayerEntity
                                && ((PlayerEntity) p_239422_2_).fishingBobber != null ? 1.0F : 0.0F;
                    }});

    }}
