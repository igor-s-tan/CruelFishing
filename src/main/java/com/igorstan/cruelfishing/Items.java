package com.igorstan.cruelfishing;

import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.igorstan.cruelfishing.CruelFishingMod;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;
import com.igorstan.cruelfishing.RegistryReference;


public class Items {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CruelFishingMod.MODID);


    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(() -> Fluids.OIL_FLUID.get(),
                    new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

//    public static final RegistryObject<Item> FIBERGLASS_FISHING_ROD = ITEMS.register("fiberglass_fishing_rod",
//            () -> new FiberglassFishingRod(new Item.Properties().maxStackSize(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

//    @ObjectHolder("fiberglass_fishing_rod")
//    public static final Item FIBERGLASS_FISHING_ROD;
//
//    static {
//        FIBERGLASS_FISHING_ROD = null;
//    }

}

