package com.aperriz.testing.datagen;

import com.aperriz.testing.tags.ModBlockTags;
import com.aperriz.testing.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput p_255871_, CompletableFuture<HolderLookup.Provider> p_256035_, TagsProvider<Block> p_256467_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255871_, p_256035_, p_256467_, modId, existingFileHelper);
    }

    @SubscribeEvent
    protected void addTags(HolderLookup.Provider p_256380_) {

        this.copy(ModBlockTags.AZURA_LOGS, ModItemTags.AZURA_LOGS);

    }


}
