package com.igorstan.cruelfishing.network.dictionary;

import com.igorstan.cruelfishing.network.Network;
import com.igorstan.cruelfishing.playerdata.IStockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarket;
import com.igorstan.cruelfishing.playerdata.StockMarketCapabilityProvider;
import javafx.util.Pair;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FishDictionary {
    public Pair<String, Integer> fish;

    public FishDictionary(Pair<String, Integer> fish) {
        this.fish = fish;
    }

    public static void encode(FishDictionary fishDictionary, PacketBuffer buffer) {
        buffer.writeInt(fishDictionary.fish.getValue());
        buffer.writeString(fishDictionary.fish.getKey());

    }

    public static FishDictionary decode(PacketBuffer buffer) {
        return new FishDictionary(new Pair<>(buffer.readString(), buffer.readInt()));
    }

    public static void handle(FishDictionary fishDictionary, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            IStockMarket iStockMarket = context.getSender().getCapability(StockMarketCapabilityProvider.capability).orElseGet(StockMarket::new);
            iStockMarket.setFishAmount(fishDictionary.fish.getKey(), fishDictionary.fish.getValue());
        });
        context.setPacketHandled(true);
    }
}
