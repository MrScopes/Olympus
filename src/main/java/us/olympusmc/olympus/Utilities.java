package us.olympusmc.olympus;

import org.bukkit.ChatColor;

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
            case "aqua":
                return "&b";
            case "darkred":
                return "&4";
            case "darkgreen":
                return "&2";
            case "darkblue":
                return "&1";
            case "gold":
                return "&6";
            case "yellow":
                return "&e";
            case "darkaqua":
                return "&3";
            case "blue":
                return "&9";
            case "pink":
                return "&d";
            case "purple":
                return "&5";
            case "white":
                return "&f";
            case "gray":
                return "&7";
            case "darkgray":
                return "&8";
            case "black":
                return "&0";
            default:
                return null;
        }
    }

    public static void setConfig(String key, Object value) {
        Olympus olympus = Olympus.get();
        olympus.getConfig().set(key, value);
        olympus.saveConfig();
    }
}