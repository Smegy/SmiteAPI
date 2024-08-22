package smitegee.smiteapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class SmiteAPI extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("SmiteAPI has been enabled.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("SmiteAPI has been disabled!");
    }


}
