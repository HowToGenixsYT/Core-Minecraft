package de.HowToGenius.Loader;

import de.HowToGenius.main.Main;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

@RequiredArgsConstructor
public class CommandLoader {
    private final Main plugin;

    public void onCommandLoader() {
            this.plugin.getCommand("gm").setExecutor(new de.HowToGenius.command.GamemodeCommand(this));
            this.plugin.getCommand("day").setExecutor(new de.HowToGenius.command.DayCommand(this));
            this.plugin.getCommand("night").setExecutor(new de.HowToGenius.command.NightCommand(this));
            this.plugin.getCommand("bc").setExecutor(new de.HowToGenius.command.BroadcastCommand(this));
            this.plugin.getCommand("kick").setExecutor(new de.HowToGenius.command.KickCommand(this));
            this.plugin.getCommand("fly").setExecutor(new de.HowToGenius.command.FlyCommand(this));
            this.plugin.getCommand("punish").setExecutor(new de.HowToGenius.command.PunishCommand(this));
            this.plugin.getCommand("unpun").setExecutor(new de.HowToGenius.command.UnpunCommand(this));
            this.plugin.getCommand("notify").setExecutor(new de.HowToGenius.command.NotifyCommand(this));
            this.plugin.getCommand("prefix").setExecutor(new de.HowToGenius.command.PrefixCommand(this));

            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fBroadcastCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fDayCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fFlyCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fGamemodeCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fKickCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fNightCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fNotifyCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fPrefixCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fPunishCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aCommand: §fUnpunCommand §awurde geladen.");
            Bukkit.getConsoleSender().sendMessage("§bCore ✘ §aAlle §fCommands §awurden erfolgreich geladen.");
    }
}
