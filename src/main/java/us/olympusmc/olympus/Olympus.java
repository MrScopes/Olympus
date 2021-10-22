package us.olympusmc.olympus;

import org.bukkit.plugin.java.JavaPlugin;
import us.olympusmc.olympus.handlers.CommandHandler;
import us.olympusmc.olympus.handlers.ListenerHandler;

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