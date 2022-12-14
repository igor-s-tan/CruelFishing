package com.igorstan.cruelfishing.playerdata;

import hohserg.elegant.networking.api.ServerToClientPacket;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class StockMarketClientPacket implements ServerToClientPacket {
    final Map<String, Integer> dictionary;
    final boolean isDead;

    public StockMarketClientPacket(Map<String, Integer> dictionary, boolean isDead) {
        this.dictionary = dictionary;
        this.isDead = isDead;
    }

    @Override
    public void onReceive(Minecraft mc) {
        IStockMarket iStockMarket = mc.player.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            iStockMarket.setFishAmount(entry.getKey(), entry.getValue());
        }
        iStockMarket.setDead(this.isDead);
    }
}
