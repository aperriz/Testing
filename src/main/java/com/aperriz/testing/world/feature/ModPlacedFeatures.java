package com.aperriz.testing.world.feature;

import com.aperriz.testing.block.ModBlocks;
import com.aperriz.testing.testing;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {


    public static final ResourceKey<PlacedFeature> AZURA_PLACED_KEY = createKey("azura_placed");
    public static final ResourceKey<PlacedFeature> RAINBOW_EUCALYPTUS_PLACED_KEY = createKey("rainbow_eucalyptus_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AZURA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AZURA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2)));

        register(context, RAINBOW_EUCALYPTUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RAINBOW_EUCALYPTUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2)));
        
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(testing.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}
