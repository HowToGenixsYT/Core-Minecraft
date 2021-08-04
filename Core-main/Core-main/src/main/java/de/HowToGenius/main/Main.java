package de.HowToGenius.main;

import de.HowToGenius.Config.ConfigCreator;
import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.Loader.ListenerLoader;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {


    @Getter
    private Map<String, String> prefixe = new HashMap<>();

    @Getter
    private YamlConfiguration config;


    @Getter
    private ConfigCreator configCreator;

    @Override
    public void onLoad() {
        this.configCreator = new ConfigCreator(this);
        this.configCreator.ConfigCreator();
        this.config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder() + "/config.yml"));
        this.config.getConfigurationSection("prefixe").getValues(true).forEach((k, v) -> prefixe.put(k, (String) v));
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §cDas §fPlugin §awird nun geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aDer §fListenerLoader §awird nun geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aAlle §fCommands §awerden nun geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fBroadcastCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fDayCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fFlyCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fGamemodeCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fKickCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fNightCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fNotifyCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fPrefixCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fPunishCommand §awird geladen.");
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fUnpunCommand §awird geladen.");
    }

    public void onEnable() {
        new CommandLoader(this).onCommandLoader();
        new ListenerLoader(this).ListenerLoad();

        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §bDas §aSystem §bwurde erfolgreich gestartet!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§bCore ✘ §bDas §aSystem §bwurde erfolgreich §cbeendet!");
    }
}