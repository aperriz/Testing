package com.aperriz.testing.renderer.entity;

import com.aperriz.testing.client.model.entity.MooseModel;
import com.aperriz.testing.entity.custom.MooseEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class MooseRenderer extends GeoEntityRenderer<MooseEntity> {
    public MooseRenderer(EntityRendererProvider.Context context) {
        super(context, new MooseModel());
        this.shadowRadius = 1F;
        this.scaleHeight = 2F;
        this.scaleWidth = 2F;
    }




}
