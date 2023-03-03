package com.aperriz.testing.item;

import com.aperriz.testing.testing;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = testing.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {

    public static CreativeModeTab TESTING_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){

        TESTING_TAB = event.registerCreativeModeTab(new ResourceLocation(testing.MOD_ID, "testing_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ROSS.get()))
                        .title(Component.translatable("creativemodetab.testing_tab")));

    }

}
