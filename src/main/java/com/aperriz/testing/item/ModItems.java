package com.aperriz.testing.item;

import com.aperriz.testing.block.ModBlocks;
import com.aperriz.testing.entity.ModEntityTypes;
import com.aperriz.testing.testing;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    //Item Deferred Register
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, testing.MOD_ID);

    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ROSS = ITEMS.register("ross",
            () -> new Item(new Item.Properties().stacksTo(64)));
    //Materials
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant()));
    //Sapphire tools, armor
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.CHEST, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.HEAD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.LEGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.FEET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModTiers.SAPPHIRE, 4, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModTiers.SAPPHIRE, 2, -3F, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModTiers.SAPPHIRE, 2, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModTiers.SAPPHIRE, 6, -3F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModTiers.SAPPHIRE, 2, 0F, new Item.Properties().fireResistant()));

    //Ruby tools, armor
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.CHEST, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.HEAD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.LEGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.FEET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModTiers.RUBY, 4, -2.4F, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModTiers.RUBY, 2, -3F, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModTiers.RUBY, 2, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModTiers.RUBY, 6, 3f, new Item.Properties().fireResistant()));
     public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModTiers.RUBY, 2, 3f, new Item.Properties().fireResistant()));

     public static final RegistryObject<Item> MOOSE_SPAWN_EGG = ITEMS.register("moose_spawn_egg",
             () -> new ForgeSpawnEggItem(ModEntityTypes.MOOSE, 0x422c15, 0x2e2216, new Item.Properties()));


     public static final RegistryObject<Item> RAW_VENISON = ITEMS.register("raw_venison",
             () -> new Item(new Item.Properties().food(ModFoods.RAW_VENISON)));

    public static final RegistryObject<Item> COOKED_VENISON = ITEMS.register("cooked_venison",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_VENISON)));

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }
}
