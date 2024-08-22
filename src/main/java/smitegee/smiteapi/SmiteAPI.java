package smitegee.smiteapi;

import org.bukkit.plugin.java.JavaPlugin;
import smitegee.smiteapi.Utils.ConfigUtilities.LogMessage;

public final class SmiteAPI extends JavaPlugin {


    /*
       * Hey if you're here then you are probably on GitHub!
       * So, this is the main class, feel free to look around and tell me on smitegee (Discord) if you find any issues
       *
       * Check the changelogs for anything...
       * Don't mind the jitpack class
       * and enjoy looking here :)
       *
       * Smite
     */

    @Override
    public void onEnable() {
        LogMessage.info(this, "SmiteAPI has been enabled");

    }

    @Override
    public void onDisable() {
        LogMessage.info(this, "SmiteAPI has been disabled");
    }




}
