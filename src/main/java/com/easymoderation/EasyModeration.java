package com.easymoderation;

import com.easymoderation.commands.*;
import com.easymoderation.listeners.*;
import com.easymoderation.managers.*;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyModeration extends JavaPlugin {
    private MuteManager muteManager;
    private FreezeManager freezeManager;

    @Override
    public void onEnable() {
        // Initialize managers
        muteManager = new MuteManager();
        freezeManager = new FreezeManager();

        // Register commands
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("tempban").setExecutor(new TempBanCommand());
        getCommand("mute").setExecutor(new MuteCommand(muteManager));
        getCommand("unmute").setExecutor(new UnmuteCommand(muteManager));
        getCommand("warn").setExecutor(new WarnCommand());
        getCommand("freeze").setExecutor(new FreezeCommand(freezeManager));
        getCommand("unfreeze").setExecutor(new FreezeCommand(freezeManager));

        // Register listeners
        getServer().getPluginManager().registerEvents(new ChatListener(muteManager), this);
        getServer().getPluginManager().registerEvents(new MovementListener(freezeManager), this);

        getLogger().info("EasyModeration has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EasyModeration has been disabled!");
    }
} 