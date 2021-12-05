package us.olympusmc.olympus.handlers;

import us.olympusmc.olympus.Olympus;
import org.bukkit.command.CommandExecutor;
import us.olympusmc.olympus.commands.*;

public record CommandHandler(Olympus plugin) {
    public CommandHandler(Olympus plugin) {
        this.plugin = plugin;

        registerCommand("help", new HelpCommand());
        registerCommand("color", new ColorCommand());
        registerCommand("name", new NameCommand());
        registerCommand("message", new MessageCommands());
        registerCommand("reply", new MessageCommands());
        registerCommand("spawn", new SpawnCommands());
        registerCommand("setspawn", new SpawnCommands());
    }

    private void registerCommand(String command, CommandExecutor executor) {
        plugin.getCommand(command).setExecutor(executor);
    }
}