package com.aperriz.testing;

import com.aperriz.testing.block.ModBlocks;
import com.aperriz.testing.entity.ModEntityTypes;
import com.aperriz.testing.entity.custom.MooseEntity;
import com.aperriz.testing.events.ModEvents;
import com.aperriz.testing.item.ModCreativeModeTab;
import com.aperriz.testing.item.ModItems;
import com.aperriz.testing.renderer.entity.MooseRenderer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.BusBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

import static com.aperriz.testing.block.ModBlocks.*;
import static com.aperriz.testing.item.ModItems.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(testing.MOD_ID)
public class testing
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "testingmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public static final IEventBus EVENT_BUS
            = BusBuilder.builder().startShutdown().useModLauncher().build();

    public testing()
    {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(new ModEvents());

        ModEntityTypes.ENTITIES.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {



    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            EntityRenderers.register(ModEntityTypes.MOOSE.get(), MooseRenderer::new);

        }


        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {


            event.registerEntityRenderer((EntityType) ModEntityTypes.MOOSE.get(), MooseRenderer::new);

        }

        @SubscribeEvent
        public static void registerAttributes(final EntityAttributeCreationEvent event) {


            event.put(ModEntityTypes.MOOSE.get(), MooseEntity.setAttributes());

        }
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS){

            event.accept(COOKED_VENISON);
            event.accept(RAW_VENISON);

        }

        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES){

            event.accept(RUBY_SWORD);
            event.accept(RUBY_SHOVEL);
            event.accept(RUBY_PICKAXE);
            event.accept(RUBY_AXE);
            event.accept(RUBY_HOE);

            event.accept(SAPPHIRE_SWORD);
            event.accept(SAPPHIRE_SHOVEL);
            event.accept(SAPPHIRE_PICKAXE);
            event.accept(SAPPHIRE_AXE);
            event.accept(SAPPHIRE_HOE);

        }

        if (event.getTab() == CreativeModeTabs.COMBAT){

            event.accept(SAPPHIRE_HELMET);
            event.accept(SAPPHIRE_CHESTPLATE);
            event.accept(SAPPHIRE_LEGGINGS);
            event.accept(SAPPHIRE_BOOTS);

            event.accept(RUBY_HELMET);
            event.accept(RUBY_CHESTPLATE);
            event.accept(RUBY_LEGGINGS);
            event.accept(RUBY_BOOTS);

        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(SAPPHIRE_BLOCK);

            event.accept(RUBY_BLOCK);

            event.accept(AZURA_DOOR);
            event.accept(AZURA_TRAPDOOR);

        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(SAPPHIRE_ORE);
            event.accept(DEEPSLATE_SAPPHIRE_ORE);

            event.accept(RUBY_ORE);
            event.accept(DEEPSLATE_RUBY_ORE);
        }



        if (event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(SAPPHIRE);
            event.accept(RUBY);
        }

        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS){

            event.accept(MOOSE_SPAWN_EGG);

        }

        if (event.getTab() == ModCreativeModeTab.TESTING_TAB){
            event.accept(TEST);

            event.accept(ROSS);

            event.accept(SAPPHIRE);
            event.accept(SAPPHIRE_BLOCK);
            event.accept(SAPPHIRE_ORE);
            event.accept(DEEPSLATE_SAPPHIRE_ORE);

            event.accept(SAPPHIRE_HELMET);
            event.accept(SAPPHIRE_CHESTPLATE);
            event.accept(SAPPHIRE_LEGGINGS);
            event.accept(SAPPHIRE_BOOTS);

            event.accept(SAPPHIRE_SWORD);
            event.accept(SAPPHIRE_SHOVEL);
            event.accept(SAPPHIRE_PICKAXE);
            event.accept(SAPPHIRE_AXE);
            event.accept(SAPPHIRE_HOE);

            event.accept(RUBY);
            event.accept(RUBY_BLOCK);
            event.accept(RUBY_ORE);
            event.accept(DEEPSLATE_RUBY_ORE);

            event.accept(RUBY_HELMET);
            event.accept(RUBY_CHESTPLATE);
            event.accept(RUBY_LEGGINGS);
            event.accept(RUBY_BOOTS);

            event.accept(RUBY_SWORD);
            event.accept(RUBY_SHOVEL);
            event.accept(RUBY_PICKAXE);
            event.accept(RUBY_AXE);
            event.accept(RUBY_HOE);

            event.accept(AZURA_LEAVES);
            event.accept(AZURA_LOG);
            event.accept(AZURA_PLANKS);
            event.accept(AZURA_WOOD);
            event.accept(AZURA_SAPLING);
            event.accept(AZURA_SLAB);
            event.accept(STRIPPED_AZURA_LOG);
            event.accept(STRIPPED_AZURA_WOOD);
            event.accept(AZURA_DOOR);
            event.accept(AZURA_TRAPDOOR);

            event.accept(RAINBOW_EUCALYPTUS_LEAVES);
            event.accept(RAINBOW_EUCALYPTUS_LOG);
            event.accept(RAINBOW_EUCALYPTUS_PLANKS);
            event.accept(RAINBOW_EUCALYPTUS_WOOD);
            event.accept(RAINBOW_EUCALYPTUS_SAPLING);
            event.accept(RAINBOW_EUCALYPTUS_SLAB);
            event.accept(STRIPPED_RAINBOW_EUCALYPTUS_LOG);
            event.accept(STRIPPED_RAINBOW_EUCALYPTUS_WOOD);
            event.accept(RAINBOW_EUCALYPTUS_DOOR);
            event.accept(RAINBOW_EUCALYPTUS_TRAPDOOR);

            event.accept(MOOSE_SPAWN_EGG);
            event.accept(COOKED_VENISON);
            event.accept(RAW_VENISON);


        }
    }
}
