package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.OlympusPlayer;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        OlympusPlayer player = new OlympusPlayer((Player) sender);

        player.sendColored("\n &b/help&f: get help\n &b/name&f: set your name\n &b/color&f: set your name color\n &b/msg&f: message a player\n &b/r&f: reply to a player\n ");
        return true;
    }
}