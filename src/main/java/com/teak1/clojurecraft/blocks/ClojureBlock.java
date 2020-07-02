package com.teak1.clojurecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ClojureBlock extends Block {
    public ClojureBlock() {
        super(Properties.create(Material.REDSTONE_LIGHT).sound(SoundType.STONE).hardnessAndResistance(10.0f).lightValue(15));
        setRegistryName("clojure_block");
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        if (entity != null) {
//            world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
        }
    }

//    public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
//        return Direction.getFacingFromVector((float) (entity.posX - clickedBlock.getX()), (float) (entity.posY - clickedBlock.getY()), (float) (entity.posZ - clickedBlock.getZ()));
//    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
}
