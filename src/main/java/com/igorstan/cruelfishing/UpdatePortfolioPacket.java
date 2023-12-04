package com.igorstan.cruelfishing;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;


import java.util.function.Supplier;

public class UpdatePortfolioPacket {

    private final CompoundTag nbt;

    public UpdatePortfolioPacket(CompoundTag nbt) {
        this.nbt = nbt;
    }

    public UpdatePortfolioPacket(FriendlyByteBuf buffer) {
        this.nbt = buffer.readNbt();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeNbt(this.nbt);
    }

    public void handle(Supplier<NetworkEvent.Context> ctxSup) {
        NetworkEvent.Context ctx = ctxSup.get();
        ctx.enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) {
                return;
            }
            Portfolio portfolio = mc.player.getCapability(PortfolioCapability.PORTFOLIO).orElseThrow(() -> new IllegalArgumentException());
            portfolio.loadNBT(this.nbt);
        });

        ctx.setPacketHandled(true);
    }
}
