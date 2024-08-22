package smitegee.smiteapi.Utils.PlayerUtils;

import org.bukkit.entity.Player;

import java.util.UUID;

public class getPlayerData {

    /**
     *
     * @param player Gets the player
     * @return Returns thier UUID
     */
    public static UUID getPlayerUUID(Player player) {
        UUID playerUUID = player.getUniqueId();
        return playerUUID;
    }

    /**
     *
     * @param player Gets the player
     * @return Returns the player's name
     */

    public static String getPlayerName(Player player) {
        String playerName = player.getName();
        return playerName;
    }

    /**
     *
     * @param player Gets the player
     * @return Returns if the player is online
     */
    public static boolean isPlayerOnline(Player player) {
        boolean isOnline = player.isOnline();
        return isOnline;
    }

}