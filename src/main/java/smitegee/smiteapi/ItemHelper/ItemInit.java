package smitegee.smiteapi.ItemHelper;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

    public ItemStack makeItem(Material mat, int amount, String itemName) {
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(itemName);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    public ItemStack makeItem(Material mat, int amount) {
        return new ItemStack(mat, amount);
    }

    public void makeItem(Material mat, int amount, String itemName, Player player) {
        ItemStack item = makeItem(mat, amount, itemName);
        player.getInventory().addItem(item);
    }

    public void makeItem(Material mat, int amount, ChatColor color, String itemName, Player player) {
        ItemStack item = makeItem(mat, amount, color, itemName);
        player.getInventory().addItem(item);
    }

    public ItemStack makeItem(Material mat, int amount, ChatColor color, String itemName) {
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(color + itemName);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    public ItemStack makeItemWithLore(Material mat, int amount, String itemName, List<String> lore) {
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(itemName);
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    public ItemStack makeEnchantedItem(Material mat, int amount, String itemName, Enchantment enchantment, int enchantmentLevel) {
        ItemStack item = makeItem(mat, amount, itemName);
        item.addUnsafeEnchantment(enchantment, enchantmentLevel);
        return item;
    }
}
