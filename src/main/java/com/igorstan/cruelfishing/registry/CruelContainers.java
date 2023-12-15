package com.igorstan.cruelfishing.registry;

import com.igorstan.cruelfishing.CruelFishingMod;

import com.igorstan.cruelfishing.client.container.TabletContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class  CruelContainers {
    public static final DeferredRegister<MenuType<?>> CRUEL_CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CruelFishingMod.MODID);

    public static final RegistryObject<MenuType<TabletContainer>> TABLET_CONTAINER = CRUEL_CONTAINERS.register("tablet_container", () -> IForgeMenuType.create(TabletContainer::new));
}
