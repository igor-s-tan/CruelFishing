package com.igorstan.cruelfishing.network;

import com.igorstan.cruelfishing.CruelFishingMod;
import com.igorstan.cruelfishing.network.dictionary.FishDictionary;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Network {
    public static final String NETWORK_VERSION = "0.1.0";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(CruelFishingMod.MODID, "network"),
            () -> NETWORK_VERSION, version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static void init() {
        CHANNEL.registerMessage(0, FishDictionary.class, FishDictionary::encode, FishDictionary::decode, FishDictionary::handle);
    }

}
