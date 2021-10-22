package us.olympusmc.olympus.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import us.olympusmc.olympus.OlympusPlayer;

public class Chat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        event.renderer((source, sourceDisplayName, message, viewer) ->
                Component.text().append(Component.text(new OlympusPlayer(source).displayName()), Component.text(": ", NamedTextColor.DARK_GRAY), message).build());
    }
}