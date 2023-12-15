package com.igorstan.cruelfishing.network;

import com.igorstan.cruelfishing.client.container.TabletContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public class OpenTabletPacket {
    public OpenTabletPacket() {}
    public OpenTabletPacket(FriendlyByteBuf buffer) {}
    public void toBytes(FriendlyByteBuf buffer) {}

    public void handle(Supplier<NetworkEvent.Context> ctxSup) {
        NetworkEvent.Context ctx = ctxSup.get();
        ctx.enqueueWork(() -> {
            ServerPlayer sender = ctx.getSender();
            if (sender != null) {
                NetworkHooks.openScreen(sender, new SimpleMenuProvider((id, inventory, player) ->
                        new TabletContainer(id, inventory), Component.translatable("Tablet")));

            }
        });
        ctx.setPacketHandled(true);
    }
}
