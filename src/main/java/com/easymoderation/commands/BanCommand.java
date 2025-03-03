package com.easymoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if (!sender.hasPermission("easymod.ban")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        String banReason = args.length > 1 ? String.join(" ", args).substring(args[0].length()).trim() : "Banned by an administrator";
        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), banReason, null, sender.getName());
        target.kickPlayer(ChatColor.RED + banReason);
        Bukkit.broadcastMessage(ChatColor.RED + target.getName() + " was banned by " + sender.getName() + " for: " + banReason);
        return true;
    }
} 