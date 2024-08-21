package smitegee.smiteapi;

import org.bukkit.plugin.java.JavaPlugin;
import smitegee.smiteapi.config.ConfigManager;
import smitegee.smiteapi.economy.EconomyManager;
import smitegee.smiteapi.permissions.PermissionManager;
import smitegee.smiteapi.ItemHelper.ItemHelper;

import java.util.UUID;

public final class SmiteAPI extends JavaPlugin {

    private ConfigManager configManager;
    private PermissionManager permissionManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.configManager = new ConfigManager(this, "config.yml");
        this.permissionManager = new PermissionManager(this);
        getLogger().info("SmiteAPI has been enabled.");

        // Example usage of EconomyManager

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("SmiteAPI has been disabled!");
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public PermissionManager getPermissionManager() {
        return permissionManager;
    }
}
