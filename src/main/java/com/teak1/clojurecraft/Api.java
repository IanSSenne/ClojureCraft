package com.teak1.clojurecraft;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Api {
    private World world = null;
    Api(){ }
    public void setWorld(World w){
        this.world = w;
    }
    public String getBlock(int x,int y,int z){
        return this.world.getBlockState(new BlockPos(x,y,z)).toString();
    }
    public  boolean setBlock(int x,int y,int z, String block){
        try {
            return this.world.setBlockState(new BlockPos(x,y,z),new BlockStateParser(new StringReader(block),false).parse(true).getState());
        } catch (CommandSyntaxException e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }
}
