package de.HowToGenius.listener;

import de.HowToGenius.Loader.ListenerLoader;
import de.HowToGenius.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private ListenerLoader plugin;

    public PlayerJoin(ListenerLoader plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission("core.joinmessage.owner")) {
            e.setJoinMessage("§f§lDer Owner §4" + e.getPlayer().getDisplayName() + " §f§lhat den Server beigetreten!");
            e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe wird nun geladen...");
            e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe: §4§lOwner");
            e.getPlayer().sendMessage("§bCore ✘ §fCoregruppe wird ab der §61.7 §fverfügbar sein!");
        } else {
            if (e.getPlayer().hasPermission("core.joinmessage.admin")) {
                e.setJoinMessage("§f§lDer Administrator §4" + e.getPlayer().getDisplayName() + " §f§lhat den Server beigetreten!");
                e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe wird nun geladen...");
                e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe: §c§lAdmin");
                e.getPlayer().sendMessage("§bCore ✘ §fCoregruppe wird ab der §61.7 §fverfügbar sein!");
            } else {
                if (e.getPlayer().hasPermission("core.joinmessage.team")) {
                    e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe wird nun geladen...");
                    e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe: §e§lTeammitglied");
                    e.getPlayer().sendMessage("§bCore ✘ §fCoregruppe wird ab der §61.7 §fverfügbar sein!");
                } else {
                    e.setJoinMessage("");
                    e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe wird nun geladen...");
                    e.getPlayer().sendMessage("§bCore ✘ §fDeine Coregruppe: §3§lDefault");
                }
            }
        }
    }
}