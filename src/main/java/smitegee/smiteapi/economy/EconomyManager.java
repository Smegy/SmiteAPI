package smitegee.smiteapi.economy;

import java.util.HashMap;
import java.util.UUID;

public class EconomyManager {

    /*
    * Economy is just straight simple, makes a few things
     */
    private HashMap<UUID, Double> balances;

    public EconomyManager() {
        this.balances = new HashMap<>();
    }

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
}
