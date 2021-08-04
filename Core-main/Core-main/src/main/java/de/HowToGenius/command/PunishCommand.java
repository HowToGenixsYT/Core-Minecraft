package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import java.util.Date;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor {
    private CommandLoader plugin;

    public PunishCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.usecommand.punish")) {
            sender.sendMessage("§bCore ✘ §cDieser Command ist nicht für dich zugänglich! Die benötigte Permission lautet: §fcore.usecommand.punish");
            return true;
        } else if (args.length == 0) {
            return false;
        } else {
            String name = args[0];
            String reason = String.join(" ", (CharSequence[])((CharSequence[])ArrayUtils.remove(args, 0)));
            Player p = Bukkit.getPlayer(name);
            if (p == null) {
                sender.sendMessage("§bCore ✘ §cDieser Spieler ist nicht in unserer §6Datenbank §cregestriert " + name);
                return true;
            } else {
                String admin = sender.getName();
                p.kickPlayer("§bCore ✘ §fDu wurdest §c§lGEBANNT§f!\n\nModerator: " + ChatColor.RED + admin + "\n§cGrund: " + ChatColor.WHITE + reason);
                Bukkit.getBanList(Type.NAME).addBan(name, reason, (Date)null, "Ban");
                sender.sendMessage("§bCore ✘ §cDu hast " + ChatColor.DARK_GRAY + name + " §cErfolgreich für den Grund " + ChatColor.RED + reason + " §cgebpunisht!");
                return true;
            }
        }
    }
}
    