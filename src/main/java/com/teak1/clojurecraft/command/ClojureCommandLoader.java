package com.teak1.clojurecraft.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import com.mojang.brigadier.arguments.StringArgumentType;
public class ClojureCommandLoader {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        ClojureExecuteCommand executeCommand = new ClojureExecuteCommand();
        dispatcher.register(
                Commands.literal("clojure")
                        .then(Commands.literal("run").then(Commands.argument("code",StringArgumentType.greedyString()).executes(new ClojureCommand())))
                        .then(Commands.literal("gui").executes(new ClojureGuiCommand()))
                        .then(Commands.literal("call")
                                .then(Commands.argument("function",StringArgumentType.word()).executes(executeCommand)
                                    .then(Commands.argument("arguments[]",StringArgumentType.greedyString()).executes(executeCommand))))
        );
    }
}
