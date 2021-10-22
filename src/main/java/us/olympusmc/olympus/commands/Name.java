package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.OlympusPlayer;

public class Name implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        OlympusPlayer player = new OlympusPlayer((Player) sender);

        if (args.length == 0) {
            player.resetName();
            player.sendColored("&7Your new name is " + player.displayName() + "&7.");
            return true;
        }

        player.setName(args[0]);
        player.update();
        player.sendColored("&7Your new name is " + player.displayName() + "&7.");

        return true;
    }
}