package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.registry.CruelEntities;
import net.minecraft.nbt.CompoundTag;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class StocksInfo {

    private Map<String, Pair<Vector<Float>, Integer>> stocksInfoMap;


    public StocksInfo() {
        Random rand = new Random();
        Vector<Float> vector = new Vector<>();
        for(int i = 0; i < CruelResourses.PRICE_HISTORY_SIZE; ++i) {
            vector.add(rand.nextFloat(50f));
        }

        this.stocksInfoMap = new HashMap<>();

        this.stocksInfoMap.put(CruelEntities.FLESHRAT.get().getDescriptionId(), new Pair<>(vector, 1));
        this.stocksInfoMap.put("HumanStock", new Pair<>(vector, 120));
    }

    public Vector<Float> getPrices(String name) {
        return this.stocksInfoMap.get(name).a;
    }

    public void addPrice(String name, float newPrice) {
        Vector<Float> tempVec = this.stocksInfoMap.get(name).a;
        tempVec.remove(0);
        tempVec.add(newPrice);
        this.stocksInfoMap.put(name, new Pair<>(tempVec, this.stocksInfoMap.get(name).b));
    }

    public int getVolatility(String name) {
        return this.stocksInfoMap.get(name).b;
    }

    public void setVolatility(String name, int volatility) {
        this.stocksInfoMap.put(name, new Pair<>(this.stocksInfoMap.get(name).a, volatility));
    }

    public void saveNBT(CompoundTag nbt) {
        for(String key : this.stocksInfoMap.keySet()) {
            putFloatVector(nbt, this.stocksInfoMap.get(key).a, key);
        }
    }
    public void loadNBT(CompoundTag nbt) {
        this.stocksInfoMap.replaceAll((k, v) -> new Pair<>(getFloatVector(nbt, k), v.b));
    }


    private void putFloatVector(CompoundTag nbt, Vector<Float> vector, String key) {
        for(int i = 0; i < CruelResourses.PRICE_HISTORY_SIZE; ++i) {
            nbt.putFloat(key + CruelResourses.cruelStocksInfo.toString() + i, vector.get(i));
        }
    }

    private Vector<Float> getFloatVector(CompoundTag nbt, String key) {
        Vector<Float> result = new Vector<>();
        for(int i = 0; i < CruelResourses.PRICE_HISTORY_SIZE; ++i) {
            result.add(nbt.getFloat(key + CruelResourses.cruelStocksInfo.toString() + i));
        }
        return result;
    }
}
