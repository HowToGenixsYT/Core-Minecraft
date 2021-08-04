package de.HowToGenius.Config;

import de.HowToGenius.main.Main;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

import java.io.File;

@RequiredArgsConstructor
public class ConfigCreator {
    private final Main plugin;

    public void ConfigCreator() {
        File config = new File(this.plugin.getDataFolder() + "/config.yml");
        if (!config.exists()) {
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §cDas System wird nun geladen§f...");
            this.plugin.getLogger().info("Erstelle eine config.yml Datei!");
            // this.plugin.getConfig().options().copyDefaults(true);
            this.plugin.saveDefaultConfig();
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aDie Config wurde erfolgreich erstellt!");
        }
        if (config.exists()) {
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aDie Config wurde erfolgreich gefunden und wird nun geladen!");
        }
    }
}