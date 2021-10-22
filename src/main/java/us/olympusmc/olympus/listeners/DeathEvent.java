package us.olympusmc.olympus.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class DeathEvent implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity victim = event.getEntity();
        LivingEntity attacker = event.getEntity().getKiller();

        if (!(victim instanceof Player) || !(attacker instanceof Player)) return;

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
        meta.setOwningPlayer((OfflinePlayer) victim);
        skull.setItemMeta(meta);
        event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), skull);
    }
}