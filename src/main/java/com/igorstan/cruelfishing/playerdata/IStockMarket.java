package com.igorstan.cruelfishing.playerdata;

public interface IStockMarket {
    public int getFishAmount(String fishName);

    public void setFishAmount(String fishName, int amount);

    public void addFish(String fishName, int amount);

    public void removeFish(String fishName, int amount);
}
