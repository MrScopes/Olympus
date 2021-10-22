package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.OlympusPlayer;
import us.olympusmc.olympus.Utilities;

public class ColorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        OlympusPlayer player = new OlympusPlayer((Player) sender);

        if (args.length == 0) {
            player.setValue("color", null);
            player.sendColored("&7You are now " + player.displayName() + "&7.");
            player.update();
            return true;
        }

        String color = Utilities.color(args[0]);
        if (color == null) return false;

        player.setValue("color", color);
        player.sendColored("&7You are now " + player.displayName() + "&7.");
        player.update();
        return true;
    }
}