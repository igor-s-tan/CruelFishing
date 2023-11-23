package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.FishEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class CruelCommonRegistry {
    @SubscribeEvent
    public static void entityAttributCreation(EntityAttributeCreationEvent event) {
        event.put(CruelEntities.FLESHRAT.get(), FishEntity.getCruelAttributes().build());
    }
}
