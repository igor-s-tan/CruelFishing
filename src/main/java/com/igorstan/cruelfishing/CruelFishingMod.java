package com.igorstan.cruelfishing;

import com.igorstan.cruelfishing.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.function.Consumer;

@Mod(CruelFishingMod.MODID)
public class CruelFishingMod
{
    public static final String MODID = "cruelfishing";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));

    public CruelFishingMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        CruelItems.CRUEL_ITEMS.register(modEventBus);
        CruelEntities.CRUEL_ENTITIES.register(modEventBus);
        CruelContainers.CRUEL_CONTAINERS.register(modEventBus);
        CruelNetworking.init();


        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerTab);


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {

    }
    private void registerTab(CreativeModeTabEvent.Register event)
    {
        event.registerCreativeModeTab(CruelResourses.cruelCreativeTab, builder -> {
            builder.title(CruelResourses.cruelCreavtiveTabTitle)
                    .icon(() -> new ItemStack(Items.ACACIA_BUTTON.asItem()))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(CruelItems.FIBERGLASS_FISHING_ROD.get());
                    }));
        });
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            event.enqueueWork(
                    () -> MenuScreens.register(CruelContainers.TABLET_CONTAINER.get(), TabletScreen::new)
            );
            ItemProperties.register(CruelItems.FIBERGLASS_FISHING_ROD.get(), new ResourceLocation("cast"), (pStack, pLevel, pEntity, pSeed) -> {
                if (pEntity == null) {
                    return 0.0F;
                } else {
                    boolean flag = pEntity.getMainHandItem() == pStack;
                    boolean flag1 = pEntity.getMainHandItem() == pStack;
                    if (pEntity.getMainHandItem().getItem() instanceof FiberglassFishingRodItem) {
                        flag1 = false;
                    }

                    return (flag || flag1) && pEntity instanceof Player
                            && ((Player) pEntity).fishing != null ? 1.0F : 0.0F;
                }});

        }
    }
}
