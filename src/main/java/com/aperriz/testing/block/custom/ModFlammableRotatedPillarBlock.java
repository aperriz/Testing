package com.aperriz.testing.block.custom;

import com.aperriz.testing.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {

    public ModFlammableRotatedPillarBlock(Properties properties){
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {

        if(context.getItemInHand().getItem() instanceof AxeItem){
            if(state.is(ModBlocks.AZURA_LOG.get())){
                return ModBlocks.STRIPPED_AZURA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.AZURA_WOOD.get())){
                return ModBlocks.STRIPPED_AZURA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        if(context.getItemInHand().getItem() instanceof AxeItem){
            if(state.is(ModBlocks.RAINBOW_EUCALYPTUS_LOG.get())){
                return ModBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.RAINBOW_EUCALYPTUS_WOOD.get())){
                return ModBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
