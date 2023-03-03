package com.aperriz.testing.entity;

import com.aperriz.testing.entity.custom.MooseEntity;
import com.aperriz.testing.testing;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.*;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntityTypes<T extends EntityType>{

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            testing.MOD_ID);


    public static final RegistryObject<EntityType<MooseEntity>> MOOSE = registerMob("moose", MooseEntity::new,
            2f, 3f, 0x1F1F1F, 0x0D0D0D);


    @SubscribeEvent
    public static <T extends Mob> RegistryObject<EntityType<T>> registerMob(String name, EntityType.EntityFactory<T> entity,
                                                                            float width, float height, int primaryEggColor, int secondaryEggColor) {
        RegistryObject<EntityType<T>> entityType = ENTITIES.register(name,
                () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));

        return entityType;
    }
}
