package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.OlympusPlayer;

public class NameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Command only useable by players.");
            return true;
        }

        OlympusPlayer player = new OlympusPlayer((Player) sender);

        if (args.length == 0) {
            player.resetName();
            player.sendColored("&7Your new name is " + player.displayName() + "&7.");
            return true;
        }

        if (args[0].length() > 16) {
            player.sendColored("&cYour name must be shorter than 16 characters");
            return true;
        }

        player.setName(args[0]);
        player.update();
        player.sendColored("&7Your new name is " + player.displayName() + "&7.");

        return true;
    }
}