package com.easymoderation.commands;

import com.easymoderation.utils.DurationParser;
import org.bukkit.Bukkit;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Date;

public class TempBanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            return false;
        }

        if (!sender.hasPermission("easymod.tempban")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        try {
            long duration = DurationParser.parseDuration(args[1]);
            String tempbanReason = args.length > 2 ? String.join(" ", args).substring(args[0].length() + args[1].length()).trim() : "Temporarily banned";
            Date expiry = new Date(System.currentTimeMillis() + duration);
            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), tempbanReason, expiry, sender.getName());
            target.kickPlayer(ChatColor.RED + tempbanReason);
            Bukkit.broadcastMessage(ChatColor.RED + target.getName() + " was temporarily banned by " + sender.getName() + " for: " + tempbanReason);
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + "Invalid duration format! Use: 1d, 2h, 30m, etc.");
        }
        return true;
    }
} 