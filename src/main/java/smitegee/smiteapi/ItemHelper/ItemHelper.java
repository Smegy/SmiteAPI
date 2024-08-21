package smitegee.smiteapi.ItemHelper;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemHelper {

    private ItemHelper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates an ItemStack with a specified material, amount, and display name.
     *
     * @param material   The material of the item.
     * @param amount     The amount of the item.
     * @param displayName The display name of the item.
     * @return The created ItemStack.
     */
    public static ItemStack makeItem(Material material, int amount, String displayName) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(displayName);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    /**
     * Creates an ItemStack with a specified material and amount.
     *
     * @param material The material of the item.
     * @param amount   The amount of the item.
     * @return The created ItemStack.
     */
    public static ItemStack makeItem(Material material, int amount) {
        return new ItemStack(material, amount);
    }

    /**
     * Creates and gives an item to a player with a specified material, amount, and display name.
     *
     * @param material   The material of the item.
     * @param amount     The amount of the item.
     * @param displayName The display name of the item.
     * @param player     The player to receive the item.
     */
    public static void giveItem(Material material, int amount, String displayName, Player player) {
        ItemStack item = makeItem(material, amount, displayName);
        player.getInventory().addItem(item);
    }

    /**
     * Creates and gives an item to a player with a specified material, amount, display name, and color.
     *
     * @param material   The material of the item.
     * @param amount     The amount of the item.
     * @param color      The color to apply to the display name.
     * @param displayName The display name of the item.
     * @param player     The player to receive the item.
     */
    public static void giveItem(Material material, int amount, ChatColor color, String displayName, Player player) {
        ItemStack item = makeItem(material, amount, color, displayName);
        player.getInventory().addItem(item);
    }

    /**
     * Creates an ItemStack with a specified material, amount, color, and display name.
     *
     * @param material   The material of the item.
     * @param amount     The amount of the item.
     * @param color      The color to apply to the display name.
     * @param displayName The display name of the item.
     * @return The created ItemStack.
     */
    public static ItemStack makeItem(Material material, int amount, ChatColor color, String displayName) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(color + displayName);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    /**
     * Creates an ItemStack with a specified material, amount, display name, and lore.
     *
     * @param material   The material of the item.
     * @param amount     The amount of the item.
     * @param displayName The display name of the item.
     * @param lore       The lore to add to the item.
     * @return The created ItemStack.
     */
    public static ItemStack makeItemWithLore(Material material, int amount, String displayName, List<String> lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(displayName);
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    /**
     * Creates an enchanted ItemStack with a specified material, amount, display name, and enchantment.
     *
     * @param material      The material of the item.
     * @param amount        The amount of the item.
     * @param displayName   The display name of the item.
     * @param enchantment   The enchantment to apply.
     * @param enchantmentLevel The level of the enchantment.
     * @return The created enchanted ItemStack.
     */
    public static ItemStack makeEnchantedItem(Material material, int amount, String displayName, Enchantment enchantment, int enchantmentLevel) {
        ItemStack item = makeItem(material, amount, displayName);
        item.addUnsafeEnchantment(enchantment, enchantmentLevel);
        return item;
    }
}
