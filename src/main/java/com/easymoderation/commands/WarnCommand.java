package com.easymoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            return false;
        }

        if (!sender.hasPermission("easymod.warn")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        String warnReason = String.join(" ", args).substring(args[0].length()).trim();
        target.sendMessage(ChatColor.RED + "Warning from " + sender.getName() + ": " + warnReason);
        sender.sendMessage(ChatColor.GREEN + "Warning sent to " + target.getName());
        return true;
    }
} 