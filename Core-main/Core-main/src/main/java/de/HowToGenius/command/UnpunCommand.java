package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnpunCommand implements CommandExecutor {
    private CommandLoader plugin;

    public UnpunCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.usecommand.unwarn")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.unpun");
        }

        if (args.length == 0) {
            return false;
        } else {
            String name = args[0];
            Bukkit.getBanList(Type.NAME).pardon(name);
            sender.sendMessage("§bCore ✘ §aDer Spieler " + name + " §awurde erfolgreich entbannt!");
            return true;
        }
    }
}