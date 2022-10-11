package com.igorstan.cruelfishing;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.renderer.entity.FishRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.combustivefishing.CombustiveFishing;
import top.theillusivec4.combustivefishing.common.entity.BlazingFishingBobberEntity;
import com.igorstan.cruelfishing.FiberglassBobberEntity;
import top.theillusivec4.combustivefishing.common.entity.CombustiveCodEntity;
import top.theillusivec4.combustivefishing.common.entity.SearingSwordfishEntity;
import top.theillusivec4.combustivefishing.common.entity.ThrownCombustiveCodEntity;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import top.theillusivec4.combustivefishing.common.entity.BlazingFishingBobberEntity;
import top.theillusivec4.combustivefishing.common.entity.CombustiveCodEntity;
import top.theillusivec4.combustivefishing.common.entity.SearingSwordfishEntity;
import top.theillusivec4.combustivefishing.common.entity.ThrownCombustiveCodEntity;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import top.theillusivec4.combustivefishing.common.entity.BlazingFishingBobberEntity;
import top.theillusivec4.combustivefishing.common.entity.CombustiveCodEntity;
import top.theillusivec4.combustivefishing.common.entity.SearingSwordfishEntity;
import top.theillusivec4.combustivefishing.common.entity.ThrownCombustiveCodEntity;

import java.util.UUID;
import java.util.function.Supplier;

public class Entities {
    public static final EntityType<FiberglassBobberEntity> FIBERGLASS_BOBBER;
    public Entities() {}



    static {
        FIBERGLASS_BOBBER = EntityType.Builder.<FiberglassBobberEntity>create((entityType, world) -> {
            if (world.isRemote()) {
                return new FiberglassBobberEntity(world);
            } else {
                return new FiberglassBobberEntity(
                        new FakePlayer((ServerWorld) world, new GameProfile(UUID.randomUUID(), "")), world, 0,
                        0);
            }
        }, EntityClassification.MISC).size(0.25F, 0.25F).disableSerialization().disableSummoning()
                .setTrackingRange(64).immuneToFire().setUpdateInterval(5)
                .setShouldReceiveVelocityUpdates(true).build("fiberglass_bobber");
        FIBERGLASS_BOBBER.setRegistryName(CruelFishingMod.MODID, RegistryReference.FIBERGLASS_BOBBER);
    }
}
