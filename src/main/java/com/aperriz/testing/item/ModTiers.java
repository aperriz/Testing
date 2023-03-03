package com.aperriz.testing.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier SAPPHIRE = new ForgeTier(4, 5000, 11f, 5f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.SAPPHIRE.get()));
    public static final ForgeTier RUBY = new ForgeTier(4, 5000, 11f, 5f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.RUBY.get()));

}
