package us.olympusmc.olympus;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Utilities {
    public static String coloredStr(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String color(String color) {
        color = color.toLowerCase();
        switch (color) {
            case "red":
                return "&c";
            case "green":
                return "&a";
            case "blue":
                return "&b";
            default:
                return "invalid";
        }
    }

    public static String playerName(Player player) {
        String color = Olympus.get().getConfig().getString("players." + player.getUniqueId() + ".color");
        return coloredStr((color != null ? color : "&f") + player.getName());

    }

    public static void setName(Player player, String name, Boolean update) {
        PlayerProfile profile = player.getPlayerProfile();
        profile.setName(name);
        player.setPlayerProfile(profile);

        player.setPlayerListName(Utilities.playerName(player));

        if (update) {
            Olympus.get().getConfig().set("players." + player.getUniqueId() + ".name", name);
            Olympus.get().saveConfig();
        }
    }

    public static void updatePlayer(Player player, Boolean reset) {
        FileConfiguration config = Olympus.get().getConfig();

        if (config.getString("players." + player.getUniqueId()) == null) {
            defaultEntries(player);
        }

        if (reset) {
            String name = config.getString("players." + player.getUniqueId() + ".original");
            if (name == null) {
                defaultEntries(player);
                name = config.getString("players." + player.getUniqueId() + ".original");
            }

            if (name == player.getName()) return;

            setName(player, name, false);
            config.set("players." + player.getUniqueId() + ".name", null);
            Olympus.get().saveConfig();
            return;
        }

        String name = config.getString("players." + player.getUniqueId() + ".name");
        if (name != null) setName(player, name, true);
    }

    public static void defaultEntries(Player player) {
        FileConfiguration config = Olympus.get().getConfig();
        config.set("players." + player.getUniqueId() + ".original", player.getName());
        Olympus.get().saveConfig();
    }
}