package com.igorstan.cruelfishing.entity.display;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.client.ClientContainerRegistry;
import com.igorstan.cruelfishing.entity.fish.FleshratFishEntity;
import com.igorstan.cruelfishing.init.CruelEntities;
import com.igorstan.cruelfishing.playerdata.IStockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarketCapabilityProvider;
import com.igorstan.cruelfishing.registry.RegistryNames;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.sun.scenario.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import javax.annotation.ParametersAreNonnullByDefault;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CruelFishingMod.MODID, value = Dist.CLIENT)
public class TextDisplay {


    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post evtRender) {

        if(evtRender.getType() == RenderGameOverlayEvent.ElementType.ALL) {

            Minecraft mc = Minecraft.getInstance();



            float textPosX = clampVertical(mc, mc.getMainWindow().getWindowX(), "FLESHRAT ACQUIRED");
            float textPosY = clampHorizontal(mc, mc.getMainWindow().getWindowY());

            IStockMarket iStockMarket = mc.player.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);

            if(iStockMarket.getDead()) {
                mc.fontRenderer.drawString(evtRender.getMatrixStack(), "FLESHRAT ACQUIRED", textPosX, textPosY, 0xFFFFFF00);
            }
        }
    }



    private float clampVertical(Minecraft mc, float posX, String text) {
        float maxPosX = mc.getMainWindow().getScaledWidth() - mc.fontRenderer.getStringWidth(text);
        posX = Math.min(posX, maxPosX);
        return posX;
    }

    private float clampHorizontal(Minecraft mc, float posY) {
        float maxPosY = mc.getMainWindow().getScaledHeight() - mc.fontRenderer.FONT_HEIGHT;
        posY = Math.min(posY, maxPosY);
        return posY;
    }
}
