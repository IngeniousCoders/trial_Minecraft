package com.ingeniousmc.tutrialmod;

import com.google.common.collect.ImmutableMap;
import com.ingeniousmc.tutrialmod.block.ModBlocks;
import com.ingeniousmc.tutrialmod.container.ModContainers;
import com.ingeniousmc.tutrialmod.entity.ModEntityTypes;
import com.ingeniousmc.tutrialmod.entity.render.BuffZombieRenderer;
import com.ingeniousmc.tutrialmod.entity.render.PigeonRenderer;
import com.ingeniousmc.tutrialmod.fluid.ModFluids;
import com.ingeniousmc.tutrialmod.item.ModItems;
import com.ingeniousmc.tutrialmod.screen.LightningChannelerScreen;
import com.ingeniousmc.tutrialmod.tileentity.ModTileEntities;
import com.ingeniousmc.tutrialmod.world.structure.ModStructures;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(tutorialMod.MOD_ID)
public class tutorialMod
{

    public static final String MOD_ID = "tutrialmod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public tutorialMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);
        ModStructures.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModFluids.register(eventBus);

        // Add to the setup method inside the enqueueWork


        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                    .put(ModBlocks.REDWOOD_LOG.get(), ModBlocks.STRIPPED_REDWOOD_LOG.get())
                    .put(ModBlocks.REDWOOD_WOOD.get(), ModBlocks.STRIPPED_REDWOOD_WOOD.get()).build();

            ModStructures.setupStructures();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
        RenderTypeLookup.setRenderLayer(ModBlocks.AMETHYST_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.AMETHYST_TRAPDOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.OATS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HYACINTH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_LEAVES.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(ModFluids.OIL_FLUID.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.OIL_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.OIL_FLOWING.get(), RenderType.getTranslucent());

        ScreenManager.registerFactory(ModContainers.LIGHTNING_CHANNELER_CONTAINER.get(),
                LightningChannelerScreen::new);
    });

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIGEON.get(), PigeonRenderer::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
