package us.olympusmc.olympus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.olympusmc.olympus.Olympus;
import us.olympusmc.olympus.Utilities;

import java.util.ArrayList;
import java.util.List;

public class ColorCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Olympus.get().getConfig().set("players." + player.getUniqueId() + ".color", null);
            Olympus.get().saveConfig();
            sender.sendMessage(Utilities.coloredStr("You are now &f"+ sender.getName() + "."));
            player.setPlayerListName(Utilities.playerName(player));
            return true;
        }

        String color = Utilities.color(args[0]);
        if (color.equals("invalid")) return false;

        sender.sendMessage(Utilities.coloredStr("You are now " + color + sender.getName() + "&r."));
        Olympus.get().getConfig().set("players." + player.getUniqueId() + ".color", color);
        Olympus.get().saveConfig();
        player.setPlayerListName(Utilities.playerName(player));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList();
        completions.add("Red");
        completions.add("Green");
        completions.add("Blue");

        return completions;
    }
}