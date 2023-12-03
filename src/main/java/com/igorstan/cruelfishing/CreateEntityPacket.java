package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.registry.CruelEntities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.UUID;
import java.util.function.Supplier;

public class CreateEntityPacket {

    private final int id;

    public CreateEntityPacket(int id) {
        this.id = id;
    }
    public CreateEntityPacket(FriendlyByteBuf buffer) {
        this.id = buffer.readInt();
    }
    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeInt(this.id);
    }

    public void handle(Supplier<NetworkEvent.Context> ctxSup) {
        NetworkEvent.Context ctx = ctxSup.get();
        ctx.enqueueWork(() -> {
            ServerPlayer sender = ctx.getSender();
            if(sender != null) {
                FishEntity entity = new FishEntity(CruelEntities.FLESHRAT.get(), sender.level);
                entity.setId(this.id);
            }
        });
        ctx.setPacketHandled(true);
    }
}