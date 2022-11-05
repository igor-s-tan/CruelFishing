package com.igorstan.cruelfishing.playerdata;


import com.igorstan.cruelfishing.registry.RegistryNames;
import hohserg.elegant.networking.api.ClientToServerPacket;
import hohserg.elegant.networking.api.ElegantPacket;
import net.minecraft.entity.player.ServerPlayerEntity;

@ElegantPacket
public class StockMarketClientPacket implements ClientToServerPacket {
    final int FLESHRAT_AMOUNT;

    public StockMarketClientPacket(int amount){
        this.FLESHRAT_AMOUNT = amount;
    }

    @Override
    public void onReceive(ServerPlayerEntity player) {
        IStockMarket p = player.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
        p.setFishAmount(RegistryNames.FLESHRAT_FISH, this.FLESHRAT_AMOUNT);
    }
}