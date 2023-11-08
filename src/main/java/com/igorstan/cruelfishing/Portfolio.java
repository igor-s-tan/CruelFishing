package com.igorstan.cruelfishing;

import net.minecraft.nbt.CompoundTag;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Portfolio {

    private Map<String, Integer> portfolioMap;
    private double netWorth;


    public Portfolio() {
        this.portfolioMap = new HashMap<>();
        this.netWorth = 0.0D;
    }

    public int getAmount(String name) {
        return this.portfolioMap.get(name);
    }

    public void setAmount(String name, int amount) {
        this.portfolioMap.put(name, amount);
    }

    public void addAmount(String name, int amount) {
        this.setAmount(name, this.getAmount(name) + amount);
    }

    public boolean removeAmount(String name, int amount) {
        if(this.getAmount(name) >= amount) {
            this.portfolioMap.put(name, this.getAmount(name) - amount);
            return true;
        }
        return false;
    }

    public double getNetWorth() {
        return this.netWorth;
    }

    public void setNetWorth(double amount) {
        this.netWorth = amount;
    }

    public void addNetWorth(double amount) {
        this.netWorth += amount;
    }

    public boolean removeNetWorth(double amount) {
        if(this.netWorth >= amount) {
            this.netWorth -= amount;
            return true;
        }
        return false;
    }

    public void buy(String name, int amount, StocksInfo stocksInfo) {
        Vector<Float> prices = stocksInfo.getPrices(name);
        if(this.removeNetWorth(prices.get(prices.size()-1) * amount)) {
            this.addAmount(name, amount);
        }
    }

    public void sell(String name, int amount, StocksInfo stocksInfo) {
        Vector<Float> prices = stocksInfo.getPrices(name);
        if(this.removeAmount(name, amount)) {
            this.addNetWorth(prices.get(prices.size()-1) * amount);
        }
    }

    public void saveNBT(CompoundTag nbt) {
        for(String key : this.portfolioMap.keySet()) {
            nbt.putInt(key + "_" + CruelResourses.cruelPortfolio.toLanguageKey(), this.portfolioMap.get(key));
        }
        nbt.putDouble(CruelResourses.cruelNetWorth.toLanguageKey() + "_" + CruelResourses.cruelPortfolio.toLanguageKey(), this.netWorth);
    }
    public void loadNBT(CompoundTag nbt) {
        this.portfolioMap.replaceAll((key, value) -> nbt.getInt(key + "_" + CruelResourses.cruelPortfolio));
    }

}
