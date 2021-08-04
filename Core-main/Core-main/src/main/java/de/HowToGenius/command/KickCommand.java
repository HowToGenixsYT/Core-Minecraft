package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
    private CommandLoader plugin;

    public KickCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.usecommand.kick")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.kick");
            return true;
        } else if (args.length == 0) {
            return false;
        } else {
            String name = args[0];
            String reason = String.join(" ", (CharSequence[])((CharSequence[])ArrayUtils.remove(args, 0)));
            Player p = Bukkit.getPlayer(name);
            if (p == null) {
                sender.sendMessage("§bCore ✘ §cKonnte " + name + " §cnicht finden!");
                return true;
            } else {
                String admin = sender.getName();
                p.kickPlayer("§bCore ✘ §cDu wurdest vom Server gekickt! \n§fGrund: " + reason);
                sender.sendMessage("§bCore ✘ §aDer Spieler " + name + " §awurde für den Grund " + reason + "§agekickt!");
                return true;
            }
        }
    }
}