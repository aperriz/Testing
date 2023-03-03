package com.aperriz.testing.tags;

import com.aperriz.testing.testing;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> AZURA_LOGS = create("azura_logs");
    public static final TagKey<Block> RAINBOW_EUCALYPTUS_LOGS = create("rainbow_eucalyptus_logs");

    private static TagKey<Block> create(String p_203847_) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(testing.MOD_ID, p_203847_));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }

}
