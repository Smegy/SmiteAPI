package smitegee.smiteapi.economy;

import java.util.HashMap;
import java.util.UUID;

public class EconomyManager {

    private static final HashMap<UUID, Double> balances = new HashMap<>();

    // Get the balance of a player by their UUID
    public static double getBalance(UUID playerUUID) {
        return balances.getOrDefault(playerUUID, 0.0);
    }

    // Set the balance of a player by their UUID
    public static void setBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, amount);
    }

    // Add to the balance of a player by their UUID
    public static void addBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) + amount);
    }

    // Subtract from the balance of a player by their UUID
    public static void subtractBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) - amount);
    }

    // Transfer balance from one player to another
    public static boolean transferBalance(UUID fromPlayer, UUID toPlayer, double amount) {
        if (getBalance(fromPlayer) >= amount) {
            subtractBalance(fromPlayer, amount);
            addBalance(toPlayer, amount);
            return true;
        }
        return false;
    }
}
