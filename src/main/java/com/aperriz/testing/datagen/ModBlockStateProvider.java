package com.aperriz.testing.datagen;

import com.aperriz.testing.block.ModBlocks;
import com.aperriz.testing.testing;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, testing.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.RUBY_BLOCK);
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.AZURA_TRAPDOOR.get(),new ResourceLocation(testing.MOD_ID, "block/azura_trapdoor"), true,"cutout");
        doorBlockWithRenderType((DoorBlock) ModBlocks.AZURA_DOOR.get(), new ResourceLocation(testing.MOD_ID, "block/azura_door_bottom"),new ResourceLocation(testing.MOD_ID, "block/azura_door_top"),"cutout");
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
