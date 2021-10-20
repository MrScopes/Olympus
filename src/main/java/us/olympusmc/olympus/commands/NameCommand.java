package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.Utilities;

public class NameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Utilities.updatePlayer(player, true);
            sender.sendMessage("reset name");
            return true;
        }

        Utilities.setName((Player) sender, args[0], true);
        sender.sendMessage("updated name");

        return true;
    }
}