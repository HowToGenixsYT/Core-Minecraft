package de.HowToGenius.listener;

import de.HowToGenius.Loader.ListenerLoader;
import de.HowToGenius.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    private ListenerLoader plugin;

    public PlayerLeave(ListenerLoader plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (e.getPlayer().hasPermission("coresystem.joinmessage.owner")) {
            e.setQuitMessage("§bCore ✘ §cDer Owner §4§l " + e.getPlayer().getDisplayName() + " §chat den Server verlassen!");
        } else if (e.getPlayer().hasPermission("coresystem.joinmessage.admin")) {
            e.setQuitMessage("§bCore ✘ §cDer Admin §4§l " + e.getPlayer().getDisplayName() + " §chat den Server verlassen!");
        } else {
            if (e.getPlayer().hasPermission("coresystem.joinmessage.team")) {
                e.setQuitMessage("§bCore ✘ §7Das Teammitglied §f§l " + e.getPlayer().getDisplayName() + " §7hat den Server verlassen!");
            } else {
                e.setQuitMessage("");
            }

        }
    }
}