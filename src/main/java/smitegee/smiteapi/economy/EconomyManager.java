package smitegee.smiteapi.economy;

import java.util.HashMap;
import java.util.UUID;

public class EconomyManager {

    private static final HashMap<UUID, Double> balances = new HashMap<>();

    /**
     *
     * @param playerUUID The Player's UUID
     * @return Returns the player's balances.
     */
    public static double getBalance(UUID playerUUID) {
        return balances.getOrDefault(playerUUID, 0.0);
    }

    /**
     *
     * @param playerUUID The Player's UUID
     * @param amount The amount to set in the players balances.
     */
    public static void setBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, amount);
    }

    /**
     *
     * @param playerUUID The Players UUID
     * @param amount The amount to add to the player's balances
     */
    public static void addBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) + amount);
    }

    /**
     *
     * @param playerUUID The Player's UUID.
     * @param amount The amount you want to remove from the player's balances
     */
    public static void subtractBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) - amount);
    }

    /**
     *
     * @param fromPlayer The Player's UUID you want to remove the money from.
     * @param toPlayer The Player's UUID you want to add the money to.
     * @param amount The amount to exchange between the players.
     * @return Returns true
     */
    public static boolean transferBalance(UUID fromPlayer, UUID toPlayer, double amount) {
        if (getBalance(fromPlayer) >= amount) {
            subtractBalance(fromPlayer, amount);
            addBalance(toPlayer, amount);
            return true;
        }
        return false;
    }
}
