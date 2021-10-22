package us.olympusmc.olympus.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import us.olympusmc.olympus.OlympusPlayer;

public class Login implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        new OlympusPlayer(event.getPlayer()).update();
    }
}