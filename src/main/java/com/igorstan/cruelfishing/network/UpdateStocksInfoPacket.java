package com.igorstan.cruelfishing.network;

import com.igorstan.cruelfishing.stocks.StocksInfo;
import com.igorstan.cruelfishing.capability.StocksInfoCapability;
import com.igorstan.cruelfishing.registry.CruelEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateStocksInfoPacket {
    private final CompoundTag nbt;

    public UpdateStocksInfoPacket(CompoundTag nbt) {
        this.nbt = nbt;
    }

    public UpdateStocksInfoPacket(FriendlyByteBuf buffer) {
        this.nbt = buffer.readNbt();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeNbt(this.nbt);
    }

    public void handle(Supplier<NetworkEvent.Context> ctxSup) {
        NetworkEvent.Context ctx = ctxSup.get();
        ctx.enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) {
                return;
            }
            StocksInfo stocksInfo = mc.level.getCapability(StocksInfoCapability.STOCKS_INFO).orElseThrow(() -> new IllegalArgumentException());
            stocksInfo.loadNBT(this.nbt);
            System.out.println("Packet Handled! " + stocksInfo.getPrices(CruelEntities.FLESHRAT_ENTITY.get().getDescriptionId()));
        });

        ctx.setPacketHandled(true);
    }
}
