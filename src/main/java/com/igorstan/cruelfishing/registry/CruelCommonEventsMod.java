package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.FishEntity;
import com.igorstan.cruelfishing.Portfolio;
import com.igorstan.cruelfishing.StocksInfo;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class CruelCommonEventsMod {
    @SubscribeEvent
    public static void entityAttributCreation(EntityAttributeCreationEvent event) {
        event.put(CruelEntities.FLESHRAT.get(), FishEntity.getCruelAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(StocksInfo.class);
        event.register(Portfolio.class);
    }
}
