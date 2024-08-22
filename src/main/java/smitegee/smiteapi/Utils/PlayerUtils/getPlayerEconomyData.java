package smitegee.smiteapi.Utils.PlayerUtils;

import smitegee.smiteapi.Utils.economy.EconomyManager;

import java.util.UUID;

public class getPlayerEconomyData {

    /**
     *
     * @param playerUUID the players uuid you want to get
     * @return money Returns the player balances
     */

    public static Double getPlayerBalances(UUID playerUUID) {
        Double money = EconomyManager.getBalance(playerUUID);
        return money;
    }

}