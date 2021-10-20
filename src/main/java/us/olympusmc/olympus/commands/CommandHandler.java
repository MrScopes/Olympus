package us.olympusmc.olympus.commands;

import us.olympusmc.olympus.Olympus;
import org.bukkit.command.CommandExecutor;

public record CommandHandler(Olympus plugin) {
    public CommandHandler(Olympus plugin) {
        this.plugin = plugin;

        registerCommand("color", new ColorCommand());
        registerCommand("name", new NameCommand());
    }

    private void registerCommand(String command, CommandExecutor executor) {
        plugin.getCommand(command).setExecutor(executor);
    }
}