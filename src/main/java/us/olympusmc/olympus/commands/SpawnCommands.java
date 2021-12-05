package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.Olympus;
import us.olympusmc.olympus.OlympusPlayer;

public class SpawnCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Command only useable by players.");
            return true;
        }

        OlympusPlayer player = new OlympusPlayer((Player) sender);
        FileConfiguration config = Olympus.get().getConfig();

        if (cmd.getName().equals("spawn")) {
            player.player.teleport(config.getLocation("spawn"));
            player.sendColored("&aTeleporting to spawn...");
        } else if (cmd.getName().equals("setspawn")) {
            config.set("spawn", player.player.getLocation());
            player.sendColored("&aSet the spawn point.");
        }
        return true;
    }
}