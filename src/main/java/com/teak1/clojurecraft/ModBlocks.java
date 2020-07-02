package com.teak1.clojurecraft;

import com.teak1.clojurecraft.blocks.ClojureBlock;
import com.teak1.clojurecraft.blocks.ClojureBlockTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("clojurecraft:clojure_block")
    public static ClojureBlock CLOJURE_BLOCK;

    @ObjectHolder("clojurecraft:clojure_block")
    public static TileEntityType<ClojureBlockTile> CLOJURE_BLOCK_TILE;
}
