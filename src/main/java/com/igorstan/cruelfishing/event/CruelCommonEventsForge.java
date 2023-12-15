package com.igorstan.cruelfishing.event;

import com.igorstan.cruelfishing.*;
import com.igorstan.cruelfishing.capability.PortfolioCapability;
import com.igorstan.cruelfishing.capability.StocksInfoCapability;
import com.igorstan.cruelfishing.network.CruelNetworking;
import com.igorstan.cruelfishing.network.UpdatePortfolioPacket;
import com.igorstan.cruelfishing.network.UpdateStocksInfoPacket;
import com.igorstan.cruelfishing.registry.CruelEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.Vector;

@Mod.EventBusSubscriber(modid = CruelFishingMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CruelCommonEventsForge {

    private static StocksInfoCapability capability = new StocksInfoCapability();

    @SubscribeEvent
    public static void onAttachCapabilitiesLevel(AttachCapabilitiesEvent<Level> event) {
        if (!event.getObject().getCapability(StocksInfoCapability.STOCKS_INFO).isPresent()) {
            event.addCapability(CruelResourses.cruelStocksInfo, capability);

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
        if(!event.level.isClientSide && event.phase == TickEvent.Phase.END) {
            if (event.level.dimension() == Level.OVERWORLD) {
                event.level.getCapability(StocksInfoCapability.STOCKS_INFO).ifPresent(stocksInfo -> {
                    Random rand = new Random();
                    int vol = rand.nextInt(500);
                    if (stocksInfo.getVolatility(CruelEntities.FLESHRAT.get().getDescriptionId()) >= vol) {
                        Vector<Float> prices = stocksInfo.getPrices(CruelEntities.FLESHRAT.get().getDescriptionId());
                        int sign = 1;
                        if (rand.nextBoolean()) {
                            sign = -1;
                        }
                        stocksInfo.addPrice(CruelEntities.FLESHRAT.get().getDescriptionId(), prices.get(prices.size() - 1) + sign * rand.nextFloat(prices.get(prices.size() - 1) / 2));
                        for (Player player : event.level.players()) {
                            player.getCapability(PortfolioCapability.PORTFOLIO).ifPresent(portfolio -> {
                                CompoundTag nbt = new CompoundTag();
                                portfolio.saveNBT(nbt);
                                CruelNetworking.sendToClient(new UpdatePortfolioPacket(nbt), player);
                            });
                        }
                        CompoundTag levelNBT = new CompoundTag();
                        stocksInfo.saveNBT(levelNBT);
                        CruelNetworking.sendToAllClients(new UpdateStocksInfoPacket(levelNBT));
                    }
                });
            }
        }
    }
}
