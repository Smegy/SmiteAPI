package smitegee.smiteapi;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import smitegee.smiteapi.ItemHelper.ItemHelper;
import smitegee.smiteapi.PlayerUtils.getUUID;

import java.util.Arrays;
import java.util.UUID;

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
