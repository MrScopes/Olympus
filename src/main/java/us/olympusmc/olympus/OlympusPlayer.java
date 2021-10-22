package us.olympusmc.olympus;

import com.destroystokyo.paper.profile.PlayerProfile;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OlympusPlayer  {
    Player player;

    public OlympusPlayer(Player player) {
        this.player = player;
    }

    public void sendColored(String message) {
        player.sendMessage(Utilities.coloredStr(message));
    }

    public String getValue(String key) {
        return Olympus.get().getConfig().getString("players." + player.getUniqueId() + "." + key);
    }

    public void setValue(String key, Object value) {
        Utilities.setConfig("players." + player.getUniqueId() + "." + key, value);
    }

    public void setName(String name) {
        PlayerProfile profile = player.getPlayerProfile();
        profile.setName(name);
        player.setPlayerProfile(profile);

        setValue("name", name);
    }

    public void resetName() {
        String original = getValue("original");
        if (original == null) setName(player.getName());
        original = getValue("original");
        setName(original);
        update();
    }

    public @NotNull String displayName() {
        String color = getValue("color");
        return Utilities.coloredStr((color != null ? color : "&f") + player.getName());
    }

    public void update() {
        if (getValue("original") == null) setValue("original", player.getName());
        String name = getValue("name");
        if (player.getName() != name && name != null) setName(name);
        player.playerListName(Component.text(displayName()));
    }
}
