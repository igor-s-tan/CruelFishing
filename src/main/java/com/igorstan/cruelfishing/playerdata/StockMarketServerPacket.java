package com.igorstan.cruelfishing.playerdata;

import com.igorstan.cruelfishing.registry.RegistryNames;
import hohserg.elegant.networking.api.ElegantPacket;
import hohserg.elegant.networking.api.ServerToClientPacket;
import net.minecraft.client.Minecraft;

@ElegantPacket
public class StockMarketServerPacket implements ServerToClientPacket {
    final int FLESHRAT_AMOUNT;

    public StockMarketServerPacket(int amount){
        this.FLESHRAT_AMOUNT = amount;
    }

    @Override
    public void onReceive(Minecraft mc) {
        IStockMarket p = mc.player.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
        p.setFishAmount(RegistryNames.FLESHRAT_FISH, this.FLESHRAT_AMOUNT);
    }
}
