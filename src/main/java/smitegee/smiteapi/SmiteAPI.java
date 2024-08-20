package smitegee.smiteapi;

import org.bukkit.plugin.java.JavaPlugin;
import smitegee.smiteapi.ItemHelper.ItemInit;
import smitegee.smiteapi.config.ConfigManager;
import smitegee.smiteapi.economy.EconomyManager;
import smitegee.smiteapi.permissions.PermissionManager;

public final class SmiteAPI extends JavaPlugin {

    private ItemInit itemInit;
    private ConfigManager configManager;
    private EconomyManager economyManager;
    private PermissionManager permissionsManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.itemInit = new ItemInit();
        this.configManager = new ConfigManager(this, "config.yml");
        this.economyManager = new EconomyManager();
        this.permissionsManager = new PermissionManager(this);
        getLogger().info("SmiteAPI has been enabled, please help me bro i am bored");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("SmiteAPI has been disabled!");
    }

    public ItemInit getItemInit() {
        return itemInit;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }

    public PermissionManager getPermissionsManager() {
        return permissionsManager;
    }
}
