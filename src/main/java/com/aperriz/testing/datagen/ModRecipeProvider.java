package com.aperriz.testing.datagen;

import com.aperriz.testing.block.ModBlocks;
import com.aperriz.testing.tags.ModItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.IShapedRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        planksFromLogs(consumer, ModBlocks.AZURA_PLANKS.get(), ModItemTags.AZURA_LOGS, 4);
        doorBuilder(ModBlocks.AZURA_DOOR.get(), Ingredient.of(ModBlocks.AZURA_PLANKS.get()));
        trapdoorBuilder(ModBlocks.AZURA_TRAPDOOR.get(), Ingredient.of(ModBlocks.AZURA_PLANKS.get()));

    }
}
