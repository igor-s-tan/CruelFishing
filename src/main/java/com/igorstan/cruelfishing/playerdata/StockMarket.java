package com.igorstan.cruelfishing.playerdata;

import com.igorstan.cruelfishing.registry.RegistryNames;

import java.util.HashMap;
import java.util.Map;

public class StockMarket implements IStockMarket {
    private Map<String, Integer> dictionary = new HashMap<String, Integer>();

    private boolean isDead;

    public StockMarket() {
        this.dictionary.put(RegistryNames.FLESHRAT_FISH, 0);
        this.isDead = false;
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
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    @Override
    public boolean getDead() {
        return this.isDead;
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

    @Override
    public Map<String, Integer> getDictionary() {
        return this.dictionary;
    }
}