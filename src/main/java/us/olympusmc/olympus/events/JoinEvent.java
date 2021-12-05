package us.olympusmc.olympus.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import us.olympusmc.olympus.Olympus;
import us.olympusmc.olympus.OlympusPlayer;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            new BukkitRunnable() {
                @Override
                public void run () {
                    OlympusPlayer player = new OlympusPlayer(event.getPlayer());
                    player.sendColored("\n &7Welcome to Olympus, " + player.displayName() + "&7!\n &fSee all available commands by running /help.\n ");
                }
            }.runTaskLater(Olympus.get(), 1);
        } else {
            player.teleport(Olympus.get().getConfig().getLocation("spawn"));
        }
    }
}