package com.aperriz.testing.datagen;

import com.aperriz.testing.block.ModBlocks;
import com.aperriz.testing.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.AZURA_LOG.get());
        dropSelf(ModBlocks.AZURA_PLANKS.get());
        dropSelf(ModBlocks.AZURA_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_AZURA_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_AZURA_LOG.get());
        dropSelf(ModBlocks.AZURA_SAPLING.get());
        dropSelf(ModBlocks.AZURA_DOOR.get());
        dropSelf(ModBlocks.AZURA_TRAPDOOR.get());

        add(ModBlocks.AZURA_SLAB.get(), (p_251725_) -> {
            return this.createSlabItemTable(p_251725_);
        });

        add(ModBlocks.AZURA_LEAVES.get(), (p_249592_) -> {
            return this.createLeavesDrops(p_249592_, ModBlocks.AZURA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES);
        });

        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
