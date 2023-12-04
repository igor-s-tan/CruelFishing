package com.igorstan.cruelfishing;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class BuyFishPacket {

    private final String displayedFish;
    private final int amount;
    public BuyFishPacket(String displayedFish, int amount) {
        this.displayedFish = displayedFish;
        this.amount = amount;
    }

    public BuyFishPacket(FriendlyByteBuf buffer) {
        this.displayedFish = buffer.readUtf();
        this.amount = buffer.readInt();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeUtf(this.displayedFish);
        buffer.writeInt(this.amount);
    }

    public void handle(Supplier<NetworkEvent.Context> ctxSup) {
        NetworkEvent.Context ctx = ctxSup.get();
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            CompoundTag nbt = new CompoundTag();

            player.getCapability(PortfolioCapability.PORTFOLIO).ifPresent(portfolio -> {
                player.level.getCapability(StocksInfoCapability.STOCKS_INFO).ifPresent(stocksInfo -> {
                    if(this.amount > 0) {
                        portfolio.buy(this.displayedFish, this.amount, stocksInfo);
                    } else {
                        portfolio.sell(this.displayedFish, -this.amount, stocksInfo);
                    }
                });
                portfolio.saveNBT(nbt);
            });
            CruelNetworking.sendToClient(new UpdatePortfolioPacket(nbt), player);
        });

        ctx.setPacketHandled(true);
    }
}
