package com.igorstan.cruelfishing.entity.display;

import com.igorstan.cruelfishing.registry.RegistryNames;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.sun.scenario.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TextDisplay {
    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            renderOverlay(event.getMatrixStack());
        }
    }

    public void renderOverlay(MatrixStack stack) {
        Minecraft mc = Minecraft.getInstance();

        if (mc.gameSettings.showDebugInfo) {
            return;
        }
        if (mc.player.getPersistentData().getBoolean(RegistryNames.FLESHRAT_FISH)) {
            mc.fontRenderer.drawString(stack, "Fleshrat Aquired", 20, 20, 0xFFFFFFFF);
        }
    }
}
