package smitegee.smiteapi.PlayerUtils;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class getUUID {
/**
 * This just gets the player's UUID.
 *
* @param player The player to get the UUID
 */

    public static UUID getPlayerUUID(Player player) {
        UUID playerUUID = player.getUniqueId();
        return playerUUID;
    }

}