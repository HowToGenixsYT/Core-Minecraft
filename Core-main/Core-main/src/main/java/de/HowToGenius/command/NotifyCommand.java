package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NotifyCommand implements CommandExecutor {
    private CommandLoader plugin;

    public NotifyCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("notify") && sender.hasPermission("core.usecommand.notify") && args.length == 1) {
            if (sender.hasPermission("core.usecommand.notify.an") && args[0].equals("an")) {
                sender.sendMessage("§bCore ✘ §cDu bekommst ab jetzt nun §aBenachrichtungen§c!");
                return true;
            }

            if (sender.hasPermission("core.usecommand.notify.aus") && args[0].equals("aus")) {
                sender.sendMessage("§bCore ✘ §cDu bekommst ab jetzt nun §ckeine Benachrichtungen§c!");
                return true;
            }

            if (args[0].equals("help")) {
                sender.sendMessage("§a/notify an §f(core.usecommand.notify.an)");
                sender.sendMessage("§c/notify aus §f(core.usecommand.notify.aus)");
                sender.sendMessage("§a/notify help §f(none)");
            }
        }

        return false;
    }
}