package us.olympusmc.olympus.listeners;

import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class TabComplete implements Listener {
    @EventHandler
    public void onTabComplete(AsyncTabCompleteEvent event) {
        if (event.getBuffer().split(" ")[0].equals("/color")) {
            ArrayList completions = new ArrayList();
            completions.add("red");
            completions.add("green");
            completions.add("aqua");
            completions.add("darkred");
            completions.add("darkgreen");
            completions.add("darkblue");
            completions.add("gold");
            completions.add("yellow");
            completions.add("darkaqua");
            completions.add("blue");
            completions.add("pink");
            completions.add("purple");
            completions.add("white");
            completions.add("gray");
            completions.add("darkgray");
            completions.add("black");

            event.setCompletions(completions);
        }
    }
}