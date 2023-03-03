package com.aperriz.testing.events;

import com.aperriz.testing.entity.ModEntityTypes;
import com.aperriz.testing.entity.custom.MooseEntity;
import com.aperriz.testing.testing;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Predicate;

import static net.minecraft.world.entity.animal.Wolf.PREY_SELECTOR;


@Mod.EventBusSubscriber(modid = testing.MOD_ID)
public class ModEvents {

    public static final Predicate<LivingEntity> WOLF_ADDITIONAL_PREY = (p_248371_) -> {
        EntityType<?> entitytype = p_248371_.getType();
        return entitytype == ModEntityTypes.MOOSE.get();
    };

    @SubscribeEvent
    public void onEntitySpawn(EntityJoinLevelEvent event){

        if (event.getEntity() instanceof LivingEntity){

            doTaskStuff((LivingEntity) event.getEntity(), event);

        }

    }

    private void doTaskStuff(LivingEntity e, Event ev)
    {
        if(e instanceof Wolf){

            Wolf wolf = ((Wolf) e);

            wolf.targetSelector.addGoal(5,new NonTameRandomTargetGoal<>(wolf, MooseEntity.class, false, WOLF_ADDITIONAL_PREY));

        }
    }

}


