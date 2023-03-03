package com.aperriz.testing.tags;

import com.aperriz.testing.testing;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public final class ModItemTags {
    public static TagKey<Item> AZURA_LOGS = bind("azura_logs");

    public static final TagKey<Item> RAINBOW_EUCALYPTUS_LOGS = bind("rainbow_eucalyptus_logs");

    private static TagKey<Item> bind(String p_203855_) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(testing.MOD_ID, p_203855_));
    }
}
