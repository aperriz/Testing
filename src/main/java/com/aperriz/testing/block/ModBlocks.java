package com.aperriz.testing.block;

import com.aperriz.testing.block.custom.ModFlammableRotatedPillarBlock;
import com.aperriz.testing.item.ModItems;
import com.aperriz.testing.testing;
import com.aperriz.testing.world.feature.tree.AzuraTreeGrower;
import com.aperriz.testing.world.feature.tree.RainbowEucalyptusTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, testing.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(1, 4)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(2, 7)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(1, 4)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(2, 7)));


    //Azura
    public static final RegistryObject<Block> AZURA_LOG = registerBlock("azura_log", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> AZURA_WOOD = registerBlock("azura_wood", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_AZURA_LOG = registerBlock("stripped_azura_log", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_AZURA_WOOD = registerBlock("stripped_azura_wood", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> AZURA_PLANKS = registerBlock("azura_planks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> AZURA_SLAB = registerBlock("azura_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> AZURA_LEAVES = registerBlock("azura_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops().strength(.1F))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
    public static final RegistryObject<Block> AZURA_SAPLING = registerBlock("azura_sapling", () ->
            new SaplingBlock(new AzuraTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> AZURA_DOOR = registerBlock("azura_door", () ->
            new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> AZURA_TRAPDOOR = registerBlock("azura_trapdoor", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));

    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_LOG = registerBlock("rainbow_eucalyptus_log", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_WOOD = registerBlock("rainbow_eucalyptus_wood", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_RAINBOW_EUCALYPTUS_LOG = registerBlock("stripped_rainbow_eucalyptus_log", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_RAINBOW_EUCALYPTUS_WOOD = registerBlock("stripped_rainbow_eucalyptus_wood", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_PLANKS = registerBlock("rainbow_eucalyptus_planks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_SLAB = registerBlock("rainbow_eucalyptus_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_LEAVES = registerBlock("rainbow_eucalyptus_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops().strength(.1F))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_SAPLING = registerBlock("rainbow_eucalyptus_sapling", () ->
            new SaplingBlock(new RainbowEucalyptusTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_DOOR = registerBlock("rainbow_eucalyptus_door", () ->
            new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> RAINBOW_EUCALYPTUS_TRAPDOOR = registerBlock("rainbow_eucalyptus_trapdoor", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
