package smitegee.smiteapi.economy;

import java.util.HashMap;
import java.util.UUID;

public class EconomyManager {

    private final HashMap<UUID, Double> balances = new HashMap<>();

    public double getBalance(UUID playerUUID) {
        return balances.getOrDefault(playerUUID, 0.0);
    }

    public void setBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, amount);
    }

    public void addBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) + amount);
    }

    public void subtractBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) - amount);
    }

    public boolean transferBalance(UUID fromPlayer, UUID toPlayer, double amount) {
        if (getBalance(fromPlayer) >= amount) {
            subtractBalance(fromPlayer, amount);
            addBalance(toPlayer, amount);
            return true;
        }
        return false;
    }
}
