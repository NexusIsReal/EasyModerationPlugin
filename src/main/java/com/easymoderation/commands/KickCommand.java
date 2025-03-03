package com.easymoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if (!sender.hasPermission("easymod.kick")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        String kickReason = args.length > 1 ? String.join(" ", args).substring(args[0].length()).trim() : "Kicked by an administrator";
        target.kickPlayer(ChatColor.RED + kickReason);
        Bukkit.broadcastMessage(ChatColor.YELLOW + target.getName() + " was kicked by " + sender.getName() + " for: " + kickReason);
        return true;
    }
} 