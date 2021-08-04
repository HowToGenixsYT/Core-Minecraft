package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PrefixCommand implements CommandExecutor {
    private CommandLoader plugin;

    public PrefixCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String args, String[] strings) {
        if (!sender.hasPermission("core.usecommand.prefix")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.prefix");
            return false;
        } else {
            if (sender.isOp()) {
                sender.sendMessage("§bCore ✘ §4Fehler! §cDu kannst diesen Command nicht mit der OP-Permission Ausführen!");
                return false;
            } else {
               if (!sender.isOp()) {
                   if (sender.hasPermission("core.usecommand.prefix")) {
                       sender.sendMessage("§bCore ✘ §4Fehler! §cCommand konnte nicht ausgeführt werden. Bitte durchsuche die Console auf Fehler.");
                       Bukkit.getConsoleSender().sendMessage("§bCore ✘ §cFehler: §4Command wird erst Programmiert! Command wird in der neuen Version verfügbar sein! Ab der Version: §62.0");
                       return false;
                   }
               }
            }
        }
        return false;
    }
}