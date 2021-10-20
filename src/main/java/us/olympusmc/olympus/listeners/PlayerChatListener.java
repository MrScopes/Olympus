package us.olympusmc.olympus.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import us.olympusmc.olympus.Utilities;

public class PlayerChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();

        event.setFormat(Utilities.coloredStr(Utilities.playerName(player) + "&8: &f" + event.getMessage()));
    }
}