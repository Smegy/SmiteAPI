package smitegee.smiteapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class SmiteAPI extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("SmiteAPI has been enabled.");

        // Example usage of EconomyManager

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("SmiteAPI has been disabled!");
    }

}
