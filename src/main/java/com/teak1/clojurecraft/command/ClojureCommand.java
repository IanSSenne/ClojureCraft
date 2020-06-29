package com.teak1.clojurecraft.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.teak1.clojurecraft.ClojureInterface;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;
public class ClojureCommand implements Command<CommandSource> {
    public ClojureCommand(){}

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        String[] args = context.getInput().split(" ");
        String code = "";
        for(int i = 2;i<args.length;i++){
            code+=args[i];
            if(i != args.length-1){
                code+=" ";
            }
        }
        long start = System.currentTimeMillis();
        try{
            Object res = ClojureInterface.compile(code);
            context.getSource().sendFeedback(new TranslationTextComponent(res.toString()),false);
        }catch (Exception e){
            context.getSource().sendErrorMessage(new TranslationTextComponent("clojurecraft.error"));
            try{
                context.getSource().sendErrorMessage(new TranslationTextComponent(e.toString()));
            }catch (Exception error){
                System.out.println(error.toString());
                context.getSource().sendErrorMessage(new TranslationTextComponent("clojurecraft.error.seeconsole"));
            }
        }
        long stop = System.currentTimeMillis();
        context.getSource().sendFeedback(new TranslationTextComponent("finished in "+(stop-start)+"ms"),false);
        return 0;
    }
}