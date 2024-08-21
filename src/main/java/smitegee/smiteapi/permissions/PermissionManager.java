package smitegee.smiteapi.permissions;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class PermissionManager {

    private JavaPlugin plugin;

    //Dunno why i did this but its here

    public PermissionManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean hasPermission(Player player, String permission) {
        return player.hasPermission(permission);
    }

    public void addPermission(Player player, String permission) {
        player.addAttachment(plugin, permission, true);
    }

    public void removePermission(Player player, String permission) {
        player.addAttachment(plugin, permission, false);
    }
}
