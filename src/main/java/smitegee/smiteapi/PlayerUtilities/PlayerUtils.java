package smitegee.smiteapi.PlayerUtilities;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerUtils {

    //pretty simple to understand
    public static void teleportPlayer(Player player, Location location) {
        player.teleport(location);
    }

    public static void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
