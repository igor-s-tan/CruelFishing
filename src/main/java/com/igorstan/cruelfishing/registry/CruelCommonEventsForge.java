package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CruelCommonEventsForge {

    @SubscribeEvent
    public static void onAttachCapabilitiesLevel(AttachCapabilitiesEvent<Level> event) {
        if(!event.getObject().isClientSide) {
            if (!event.getObject().getCapability(StocksInfoCapability.STOCKS_INFO).isPresent()) {
                event.addCapability(CruelResourses.cruelStocksInfo, new StocksInfoCapability());
            }
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PortfolioCapability.PORTFOLIO).isPresent()) {
                event.addCapability(CruelResourses.cruelPortfolio, new PortfolioCapability());
            }
        }
    }



    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {

//        if(!event.level.isClientSide) {
//            event.level.getCapability(StocksInfoCapability.STOCKS_INFO).ifPresent(stocksInfo -> {
//                //example
//                Random rand = new Random();
//                int vol = rand.nextInt(20);
//                if(stocksInfo.getVolatility("FleshRatStock") >= vol) {
//                    System.out.println("FleshRat Price Updated!");
//                }
//                if(stocksInfo.getVolatility("HumanStock") >= vol) {
//                    System.out.println(1);
//                }
//            });
//        }

    }




}
