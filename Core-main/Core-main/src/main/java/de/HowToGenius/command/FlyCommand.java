package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private CommandLoader plugin;

    public FlyCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.usecommand.fly")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.fly");
        }

        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Du kannst die Console nicht zum Fliegen bringen xD!");
                return true;
            }

            Player p = (Player)sender;
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                sender.sendMessage("§bCore ✘  §cDu kannst nicht fliegen!");
                return true;
            }

            p.setAllowFlight(true);
            sender.sendMessage("§bCore ✘  §aDu kannst nun fliegen!");
        }

        if (args.length == 1) {
            String name = args[0];
            Player p = Bukkit.getPlayer(name);
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                sender.sendMessage("§bCore ✘  §cDu kannst nicht fliegen!");
                return true;
            }

            p.setAllowFlight(true);
            sender.sendMessage("§bCore ✘ " + name + " §aKann nun fliegen!");
            p.sendMessage("§bCore ✘ §aDu darfst nun fliegen!");
        }

        return true;
    }
}