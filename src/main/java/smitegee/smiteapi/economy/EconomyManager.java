package smitegee.smiteapi.economy;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class EconomyManager {

    private static final ConcurrentHashMap<UUID, Double> balances = new ConcurrentHashMap<>();

    /**
     * Gets the balance for a specific player.
     *
     * @param playerUUID The UUID of the player.
     * @return The balance of the player.
     */
    public static double getBalance(UUID playerUUID) {
        return balances.getOrDefault(playerUUID, 0.0);
    }

    /**
     * Sets the balance for a specific player.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The new balance to set.
     */
    public static void setBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, amount);
    }

    /**
     * Adds an amount to the player's balance.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The amount to add.
     */
    public static void addBalance(UUID playerUUID, double amount) {
        balances.merge(playerUUID, amount, Double::sum);
    }

    /**
     * Subtracts an amount from the player's balance.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The amount to subtract.
     */
    public static void subtractBalance(UUID playerUUID, double amount) {
        balances.merge(playerUUID, -amount, Double::sum);
    }
}
