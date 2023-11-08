package com.igorstan.cruelfishing;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;


public class CruelResourses {

    public static int PRICE_HISTORY_SIZE = 10;

    public static String NULL_UUID = "00000000-0000-0000-0000-000000000000";

    public static ResourceLocation cruelCreativeTab = registerResource("cruel_tab");
    public static Component cruelCreavtiveTabTitle = registerComponent("Cruel Fishing");


    // CAPABILITIES NBT
    public static ResourceLocation cruelStocksInfo = registerResource("stocks_info");
    public static ResourceLocation cruelPortfolio = registerResource("portfolio");
    public static ResourceLocation cruelNetWorth = registerResource("net_worth");

    public static String cruelFiberglassFishingHookEntity = "fiberglass_hook";

    public static String cruelFiberglassFishingRodItem = "fiberglass_fishing_rod";

    public static String fleshratFishEntity = "fleshrat";

    public static ResourceLocation cruelRenderer = registerResource("renderer");

    public static final ResourceLocation FLESHRAT_TEXTURE = registerResource("textures/entities/fleshrat.png");

    private static ResourceLocation registerResource(String name) {
        return new ResourceLocation(CruelFishingMod.MODID, name);
    }
    private static Component registerComponent(String name) {
        return Component.translatable(name);
    }
}
