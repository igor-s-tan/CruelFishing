package com.igorstan.cruelfishing.event;

import com.igorstan.cruelfishing.*;
import com.igorstan.cruelfishing.entity.FishEntity;
import com.igorstan.cruelfishing.registry.CruelEntities;
import com.igorstan.cruelfishing.stocks.Portfolio;
import com.igorstan.cruelfishing.stocks.StocksInfo;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class CruelCommonEventsMod {
    @SubscribeEvent
    public static void entityAttributCreation(EntityAttributeCreationEvent event) {
        event.put(CruelEntities.FLESHRAT_ENTITY.get(), FishEntity.getCruelAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(StocksInfo.class);
        event.register(Portfolio.class);
    }


}
