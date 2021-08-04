package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {
    private CommandLoader plugin;

    public NightCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§bCore ✘ §cDieser Command kann nicht in der §6Console ausgeführt werden!");
            return true;
        } else if (!sender.hasPermission("core.usecommand.night")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.night");
            return true;
        } else {
            Player p = (Player)sender;
            World world = p.getWorld();
            world.setTime(14000L);
            sender.sendMessage("§bCore ✘ §aDie Zeit wurde zu §7Nacht §ageändert!");
            return true;
        }
    }
}