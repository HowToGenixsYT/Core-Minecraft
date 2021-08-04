package de.HowToGenius.Loader;

import de.HowToGenius.listener.PlayerJoin;
import de.HowToGenius.listener.PlayerLeave;
import de.HowToGenius.main.Main;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@RequiredArgsConstructor
public class ListenerLoader {
    private final Main plugin;

    public void ListenerLoad() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerLeave(this), plugin);

        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aDer §fListenerLoader §awurde erfolgreich geladen.");
    }
}
