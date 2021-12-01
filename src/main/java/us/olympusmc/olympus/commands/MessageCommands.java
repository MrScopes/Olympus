package us.olympusmc.olympus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.OlympusPlayer;

import java.util.Arrays;
import java.util.UUID;

public class MessageCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Command only useable by players.");
            return true;
        }

        OlympusPlayer player = new OlympusPlayer((Player) sender);

        if (cmd.getName().equals("message")) {
            if (args.length < 2) return false;

            Player targetOnline = Bukkit.getPlayer(args[0]);
            if (targetOnline == null) return false;

            OlympusPlayer target = new OlympusPlayer(targetOnline);

            String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

            target.sendColored("&7From &b" + player.displayName() + "&8: &f" + message);
            player.sendColored("&7To &b" + target.displayName() + "&8: &f" + message);

            target.setValue("lastSender", player.player.getUniqueId());
        } else if (cmd.getName().equals("reply")) {
            String lastSender = player.getValue("lastSender");
            if (lastSender == null) {
                player.sendColored("&cNo one's send you a message yet, loser.");
            } else {
                Player targetOnline = Bukkit.getPlayer(UUID.fromString(player.getValue("lastSender")));
                if (targetOnline == null) {
                    player.sendColored("&cThat player is offline.");
                } else {
                    OlympusPlayer target = new OlympusPlayer(targetOnline);

                    String message = String.join(" ", args);

                    target.sendColored("&7From &b" + player.displayName() + "&8: &f" + message);
                    player.sendColored("&7To &b" + target.displayName() + "&8: &f" + message);
                }
            }
        }
        return true;
    }
}