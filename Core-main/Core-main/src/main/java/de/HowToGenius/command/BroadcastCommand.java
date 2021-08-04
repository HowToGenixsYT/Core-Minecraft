package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {
    private CommandLoader plugin;

    public BroadcastCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.usecommand.broadcast")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.broadcast");
        }

        if (args.length == 0) {
            return false;
        } else {
            String msg = String.join(" ", args);
            Bukkit.broadcastMessage("§bCore ✘ " + msg);
            return true;
        }
    }
}