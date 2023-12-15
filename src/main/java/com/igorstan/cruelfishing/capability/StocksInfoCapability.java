package com.igorstan.cruelfishing.capability;

import com.igorstan.cruelfishing.network.CruelNetworking;
import com.igorstan.cruelfishing.network.UpdateStocksInfoPacket;
import com.igorstan.cruelfishing.stocks.StocksInfo;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StocksInfoCapability implements ICapabilityProvider, INBTSerializable<CompoundTag>{

    public static Capability<StocksInfo> STOCKS_INFO = CapabilityManager.get(new CapabilityToken<StocksInfo>() {});

    private StocksInfo stocksInfo = null;
    private final LazyOptional<StocksInfo> optional = LazyOptional.of(this::createStocksInfo);

    private StocksInfo createStocksInfo() {
        if(this.stocksInfo == null) {
            this.stocksInfo = new StocksInfo();
        }
        return this.stocksInfo;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == STOCKS_INFO) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createStocksInfo().saveNBT(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        CruelNetworking.sendToAllClients(new UpdateStocksInfoPacket(nbt));
        createStocksInfo().loadNBT(nbt);
    }
}
