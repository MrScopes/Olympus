package us.olympusmc.olympus.handlers;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import us.olympusmc.olympus.Olympus;
import us.olympusmc.olympus.events.*;

public record ListenerHandler(Olympus plugin) {
    public ListenerHandler(Olympus plugin) {
        this.plugin = plugin;

        registerEvent(new LoginEvent());
        registerEvent(new ChatEvent());
        registerEvent(new TabCompleteEvent());
        registerEvent(new JoinEvent());
        registerEvent(new DeathEvent());
    }

    private void registerEvent(Listener event) {
        Bukkit.getServer().getPluginManager().registerEvents(event, plugin);
    }
}