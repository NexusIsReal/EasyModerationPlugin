package com.easymoderation.commands;

import com.easymoderation.managers.FreezeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
    private final FreezeManager freezeManager;

    public FreezeCommand(FreezeManager freezeManager) {
        this.freezeManager = freezeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if (!sender.hasPermission("easymod.freeze")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("freeze")) {
            freezeManager.freezePlayer(target.getUniqueId());
            target.sendMessage(ChatColor.RED + "You have been frozen by " + sender.getName());
            sender.sendMessage(ChatColor.GREEN + "Froze " + target.getName());
        } else {
            freezeManager.unfreezePlayer(target.getUniqueId());
            target.sendMessage(ChatColor.GREEN + "You have been unfrozen by " + sender.getName());
            sender.sendMessage(ChatColor.GREEN + "Unfroze " + target.getName());
        }
        return true;
    }
} 