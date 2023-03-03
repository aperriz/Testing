package com.aperriz.testing.client.model.entity;

import com.aperriz.testing.entity.custom.MooseEntity;
import com.aperriz.testing.testing;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MooseModel extends DefaultedEntityGeoModel<MooseEntity> {
    public MooseModel() {
        super(new ResourceLocation(testing.MOD_ID, "moose"), true);
    }




}
