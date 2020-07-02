package com.teak1.clojurecraft.command;

import clojure.lang.IFn;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.teak1.clojurecraft.ClojureInterface;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

public class ClojureExecuteCommand implements Command<CommandSource> {
    public ClojureExecuteCommand(){}

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        String[] args = context.getInput().split(" ");
        Object[] params = new Object[args.length-3];//TODO: bracket matching [] () {}
        String name = args[2];
        long start = System.currentTimeMillis();
        try{
            for(int i = 3;i<args.length;i++){
                params[i-3] = ClojureInterface.compile(args[i]);
            }
            Object res = ClojureInterface.compile(name);
            if(res instanceof IFn){
                IFn test = (IFn) res;
                context.getSource().sendFeedback(new TranslationTextComponent(ClojureInterface.invoke(test,params).toString()),false);
            }else{
                context.getSource().sendFeedback(new TranslationTextComponent(res.toString()),false);
            }
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