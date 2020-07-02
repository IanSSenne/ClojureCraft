package com.teak1.clojurecraft.blocks;

import com.teak1.clojurecraft.ModBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.ITickableTileEntity;

public class ClojureBlockTile extends TileEntity implements ITickableTileEntity{
    public ClojureBlockTile(){
        super(ModBlocks.CLOJURE_BLOCK_TILE);
    }

    @Override
    public void tick() {

    }
}
