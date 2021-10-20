package us.olympusmc.olympus.listeners;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import us.olympusmc.olympus.Olympus;

public record ListenerHandler(Olympus plugin) {
    public ListenerHandler(Olympus plugin) {
        this.plugin = plugin;

        registerEvent(new PlayerLoginListener());
        registerEvent(new PlayerChatListener());
    }

    private void registerEvent(Listener event) {
        Bukkit.getServer().getPluginManager().registerEvents(event, plugin);
    }
}