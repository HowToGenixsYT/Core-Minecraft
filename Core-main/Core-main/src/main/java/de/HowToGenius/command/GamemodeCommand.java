package de.HowToGenius.command;

import de.HowToGenius.Loader.CommandLoader;
import de.HowToGenius.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    private CommandLoader plugin;

    public GamemodeCommand(CommandLoader plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.usecommand.gm")) {
            sender.sendMessage("§bCore ✘ §cDu hast keine Rechte für diesen Command! Fehlende Permission: §fcore.usecommand.gm");
            return true;
        } else if (args.length == 0) {
            return false;
        } else {
            String name;
            if (args.length == 1) {
                name = args[0];
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.RED + "Diesen Command können nur §7Spieler §causführen!");
                    return true;
                }

                Player p;
                if (name.equals("1")) {
                    p = (Player)sender;
                    p.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage("§bCore ✘ §aDein Gamemode wurde zu " + ChatColor.GOLD + "Kreativ §ageändert!");
                } else if (name.equals("0")) {
                    p = (Player)sender;
                    p.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage("§bCore ✘ §aDu hast dein Gamemode zu §7Survival §ageändert!");
                } else if (name.equals("2")) {
                    p = (Player)sender;
                    p.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage("§bCore ✘ aDu hast dein Gamemode zu §7Abenteuer §ageändert!");
                } else if (name.equals("3")) {
                    p = (Player)sender;
                    p.setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage("§bCore ✘ §aDu hast dein Gamemode zu §7Spectator §ageändert!");
                } else {
                    sender.sendMessage("§bCore ✘ §cBei der Eingabung des Commands ist ein Fehler passiert, bitte versuche es erneut! §fBenutze: §7/gm <1/2/3>");
                }
            } else if (args.length == 2) {
                name = args[1];
                String mode = args[0];
                Player p = Bukkit.getPlayer(name);
                if (p == null) {
                    sender.sendMessage("§bCore ✘ §cDer Spielmodus von" + name + " §ckonnte nicht geändert werden!");
                    return true;
                }

                if (mode.equals("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage("§bCore ✘ §aDu hast den Spielmodus von " + name + " §azu §fKreativ §ageändert!");
                    p.sendMessage("§bCore ✘ §aDein Spielmodus wurde zu §fKreativ §ageändert!");
                } else if (mode.equals("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage("§bCore ✘ §aDu hast den Spielmodus von " + name + " §azu §fSurvival §ageändert!");
                    p.sendMessage("§bCore ✘ §aDein Spielmodus wurde zu §fSurvival§ageändert!");
                } else if (mode.equals("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage("§bCore ✘ §aDu hast den Spielmodus von " + name + " §azu §fAbenteuer §ageändert!");
                    p.sendMessage("§bCore ✘ §aDein Gamemode wurde zu §fAbenteuerageändert!");
                } else if (mode.equals("3")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage("§bCore ✘ §aDu hast den Spielmodus von " + name + " §azu §fSpectator §ageändert!");
                    p.sendMessage("§bCore ✘ §aDein Spielmodus wurde zu §fSpectator§ageändert!");
                } else {
                    sender.sendMessage("§bCore ✘ §cDer Spielmodus von " + name + " §ckonnte nicht geändert werden!");
                }
            }

            return true;
        }
    }
}