package com.easymoderation.listeners;

import com.easymoderation.managers.FreezeManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
    private final FreezeManager freezeManager;

    public MovementListener(FreezeManager freezeManager) {
        this.freezeManager = freezeManager;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (freezeManager.isPlayerFrozen(event.getPlayer().getUniqueId())) {
            if (event.getFrom().getX() != event.getTo().getX() || 
                event.getFrom().getZ() != event.getTo().getZ()) {
                event.setTo(event.getFrom());
                event.getPlayer().sendMessage(ChatColor.RED + "You are frozen and cannot move!");
            }
        }
    }
} 