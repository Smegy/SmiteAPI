package smitegee.smiteapi.Utils.Useful.CommandHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommandCooldown {

    // Static map to store cooldowns for each player and command
    private static final Map<String, Map<UUID, Long>> cooldowns = new HashMap<>();

    // Static method to set a cooldown for a specific command and player
    public static void setCooldown(UUID playerUUID, String command, int cooldownSeconds) {
        long cooldownExpiry = System.currentTimeMillis() + (cooldownSeconds * 1000L);
        cooldowns.computeIfAbsent(command, k -> new HashMap<>());
        cooldowns.get(command).put(playerUUID, cooldownExpiry);
    }

    // Static method to check if a player has a cooldown for a specific command
    public static boolean hasCooldown(UUID playerUUID, String command) {
        if (!cooldowns.containsKey(command)) return false;
        Map<UUID, Long> playerCooldowns = cooldowns.get(command);
        return playerCooldowns.containsKey(playerUUID) && playerCooldowns.get(playerUUID) > System.currentTimeMillis();
    }

    // Static method to get the remaining cooldown time for a specific player and command
    public static long getRemainingCooldown(UUID playerUUID, String command) {
        if (!hasCooldown(playerUUID, command)) return 0;
        long expiryTime = cooldowns.get(command).get(playerUUID);
        return (expiryTime - System.currentTimeMillis()) / 1000L;
    }

    // Static method to clear the cooldown for a specific player and command
    public static void clearCooldown(UUID playerUUID, String command) {
        if (cooldowns.containsKey(command)) {
            cooldowns.get(command).remove(playerUUID);
        }
    }

    // Static method to clear all cooldowns for a specific player
    public static void clearAllCooldowns(UUID playerUUID) {
        for (Map<UUID, Long> playerCooldowns : cooldowns.values()) {
            playerCooldowns.remove(playerUUID);
        }
    }
}
