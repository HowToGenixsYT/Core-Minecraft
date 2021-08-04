package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {
    private CommandLoader plugin;

    public DayCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§bCore ✘ §bDu Dummkopf... Das ist die §cKonsole§f!");
            return true;
        } else if (!sender.hasPermission("core.usecommand.day")) {
            return true;
        } else {
            Player p = (Player)sender;
            World world = p.getWorld();
            world.setTime(0);
            sender.sendMessage("§bCore ✘ §aDie Zeit wurde zu §6Tag §agestellt!");
            return true;
        }
    }
}