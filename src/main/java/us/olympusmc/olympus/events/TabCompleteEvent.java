package us.olympusmc.olympus.events;

import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;

public class TabCompleteEvent implements Listener {
    @EventHandler
    public void onTabComplete(AsyncTabCompleteEvent event) {
        String[] args = event.getBuffer().split(" ");

        if (args[0].equals("/color")) {
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

            event.setCompletions(args.length > 1 ?
                    StringUtil.copyPartialMatches(args[1], completions, event.getCompletions())
                        :
                    completions
            );
        }
    }
}