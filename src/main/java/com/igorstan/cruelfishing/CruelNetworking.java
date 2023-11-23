package com.igorstan.cruelfishing;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class CruelNetworking {
    private static final String PROTOCOL_VERSION = "9";
    public static SimpleChannel INSTANCE;

    public static void init() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(CruelFishingMod.MODID, "main"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );

        int id = -1;

        INSTANCE.registerMessage(
                ++id,
                OpenTabletPacket.class,
                OpenTabletPacket::toBytes,
                OpenTabletPacket::new,
                OpenTabletPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );

        INSTANCE.registerMessage(
                ++id,
                CreateEntityPacket.class,
                CreateEntityPacket::toBytes,
                CreateEntityPacket::new,
                CreateEntityPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
    }
}
