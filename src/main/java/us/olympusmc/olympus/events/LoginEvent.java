package us.olympusmc.olympus.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import us.olympusmc.olympus.OlympusPlayer;

public class LoginEvent implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        new OlympusPlayer(event.getPlayer()).update();
    }
}