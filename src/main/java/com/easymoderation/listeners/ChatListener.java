package com.easymoderation.listeners;

import com.easymoderation.managers.MuteManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    private final MuteManager muteManager;

    public ChatListener(MuteManager muteManager) {
        this.muteManager = muteManager;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (muteManager.isPlayerMuted(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You are currently muted!");
        }
    }
} 