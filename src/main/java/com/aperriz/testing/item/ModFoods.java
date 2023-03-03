package com.aperriz.testing.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties COOKED_VENISON = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).meat().effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0), 1.0F).build();

    public static final FoodProperties RAW_VENISON = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();



}
