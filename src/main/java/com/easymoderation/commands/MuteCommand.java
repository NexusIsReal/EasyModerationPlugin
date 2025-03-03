package com.easymoderation.commands;

import com.easymoderation.managers.MuteManager;
import com.easymoderation.utils.DurationParser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor {
    private final MuteManager muteManager;

    public MuteCommand(MuteManager muteManager) {
        this.muteManager = muteManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if (!sender.hasPermission("easymod.mute")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        if (args.length < 2) {
            muteManager.mutePermanently(target.getUniqueId());
            Bukkit.broadcastMessage(ChatColor.YELLOW + target.getName() + " was muted by " + sender.getName());
        } else {
            try {
                long duration = DurationParser.parseDuration(args[1]);
                muteManager.muteTemporarily(target.getUniqueId(), duration);
                Bukkit.broadcastMessage(ChatColor.YELLOW + target.getName() + " was temporarily muted by " + sender.getName());
            } catch (IllegalArgumentException e) {
                sender.sendMessage(ChatColor.RED + "Invalid duration format! Use: 1d, 2h, 30m, etc.");
            }
        }
        return true;
    }
} 