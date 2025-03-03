package com.easymoderation.managers;

import java.util.HashMap;
import java.util.UUID;

public class MuteManager {
    private final HashMap<UUID, Long> mutedPlayers = new HashMap<>();

    public void mutePermanently(UUID uuid) {
        mutedPlayers.put(uuid, -1L);
    }

    public void muteTemporarily(UUID uuid, long duration) {
        mutedPlayers.put(uuid, System.currentTimeMillis() + duration);
    }

    public void unmute(UUID uuid) {
        mutedPlayers.remove(uuid);
    }

    public boolean isPlayerMuted(UUID uuid) {
        if (!mutedPlayers.containsKey(uuid)) {
            return false;
        }
        long muteEnd = mutedPlayers.get(uuid);
        if (muteEnd == -1) {
            return true;
        }
        if (System.currentTimeMillis() > muteEnd) {
            mutedPlayers.remove(uuid);
            return false;
        }
        return true;
    }
} 