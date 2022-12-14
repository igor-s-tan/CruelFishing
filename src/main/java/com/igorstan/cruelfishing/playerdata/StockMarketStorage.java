package com.igorstan.cruelfishing.playerdata;

import com.igorstan.cruelfishing.registry.RegistryNames;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraftforge.common.capabilities.Capability;

public class StockMarketStorage implements Capability.IStorage<IStockMarket> {

    @Override
    public INBT writeNBT(Capability<IStockMarket> capability, IStockMarket instance, net.minecraft.util.Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt(RegistryNames.FLESHRAT_FISH, instance.getFishAmount(RegistryNames.FLESHRAT_FISH));
        nbt.putBoolean(RegistryNames.FLESHRAT_FISH + "_is_dead", instance.getDead());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IStockMarket> capability, IStockMarket instance, net.minecraft.util.Direction side,
                        INBT inbt) {
        CompoundNBT nbt = (CompoundNBT) inbt;
        instance.setFishAmount(RegistryNames.FLESHRAT_FISH, nbt.getInt(RegistryNames.FLESHRAT_FISH));
        instance.setDead(nbt.getBoolean(RegistryNames.FLESHRAT_FISH + "_is_dead"));

    }
}
