package com.teak1.clojurecraft.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;


public class ClojureGuiCommand implements Command<CommandSource>{

        public ClojureGuiCommand(){}

        @Override
        public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
            context.getSource().sendFeedback(new TranslationTextComponent("clojurecraft.message.wip"),false);
            return 0;
        }
}
