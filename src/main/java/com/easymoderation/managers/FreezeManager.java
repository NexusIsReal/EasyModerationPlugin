package com.easymoderation.managers;

import java.util.HashSet;
import java.util.UUID;

public class FreezeManager {
    private final HashSet<UUID> frozenPlayers = new HashSet<>();

    public void freezePlayer(UUID uuid) {
        frozenPlayers.add(uuid);
    }

    public void unfreezePlayer(UUID uuid) {
        frozenPlayers.remove(uuid);
    }

    public boolean isPlayerFrozen(UUID uuid) {
        return frozenPlayers.contains(uuid);
    }
} 