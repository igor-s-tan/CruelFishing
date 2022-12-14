package com.igorstan.cruelfishing.playerdata;


import hohserg.elegant.networking.api.ClientToServerPacket;
import hohserg.elegant.networking.api.ElegantPacket;
import hohserg.elegant.networking.api.ServerToClientPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ElegantPacket
public class StockMarketServerPacket implements ClientToServerPacket {

    final Map<String, Integer> dictionary;
    final boolean isDead;

    public  StockMarketServerPacket(Map<String, Integer> dictionary, boolean isDead) {
        this.dictionary = dictionary;
        this.isDead = isDead;
    }

    @Override
    public void onReceive(ServerPlayerEntity player) {
        IStockMarket iStockMarket = player.getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            iStockMarket.setFishAmount(entry.getKey(), entry.getValue());
        }
        iStockMarket.setDead(this.isDead);
    }
}
