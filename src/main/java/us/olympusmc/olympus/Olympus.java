package us.olympusmc.olympus;

import us.olympusmc.olympus.commands.CommandHandler;
import us.olympusmc.olympus.listeners.ListenerHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Olympus extends JavaPlugin {

    public static Olympus instance;
    public static Olympus get() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();

        new CommandHandler(this);
        new ListenerHandler(this);
    }
}