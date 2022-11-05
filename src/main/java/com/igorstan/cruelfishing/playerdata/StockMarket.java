package com.igorstan.cruelfishing.playerdata;

import com.igorstan.cruelfishing.registry.RegistryNames;

import java.util.HashMap;
import java.util.Map;

public class StockMarket implements IStockMarket {
    private Map<String, Integer> dictionary = new HashMap<String, Integer>();

    public StockMarket() {
        this.dictionary.put(RegistryNames.FLESHRAT_FISH, 0);
    }

    @Override
    public int getFishAmount(String fishName) {
        return this.dictionary.get(fishName);
    }

    @Override
    public void setFishAmount(String fishName, int amount) {
        this.dictionary.replace(fishName, amount);
    }

    @Override
    public void addFish(String fishName, int amount) {
        this.dictionary.replace(fishName, this.getFishAmount(fishName) + amount);
    }

    @Override
    public void removeFish(String fishName, int amount) {
        int current = this.getFishAmount(fishName);
        if(current <= amount) {
            this.dictionary.replace(fishName, 0);
        }
        else {
            this.dictionary.replace(fishName, current - amount);
        }
    }
}