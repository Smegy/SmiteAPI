package smitegee.smiteapi.ItemHelper;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemHelper {


    public static ItemBuilder makeItem(Material mat, int amount) {
        return new ItemBuilder(mat, amount);
    }

    public static class ItemBuilder {
        private ItemStack item;
        private ItemMeta meta;

        public ItemBuilder(Material mat, int amount) {
            this.item = new ItemStack(mat, amount);
            this.meta = item.getItemMeta();
        }

        public ItemBuilder setName(String name) {
            if (meta != null) {
                meta.setDisplayName(name);
            }
            return this;
        }

        public ItemBuilder setLore(List<String> lore) {
            if (meta != null) {
                meta.setLore(lore);
            }
            return this;
        }

        public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
            item.addUnsafeEnchantment(enchantment, level);
            return this;
        }


        public ItemStack build() {
            if (meta != null) {
                item.setItemMeta(meta);
            }
            return item;
        }

        /*
        ItemStack myItem = ItemHelper.makeItem(Material.DIAMOND_SWORD, 1)
        .setName("Epic Sword")
        .setLore(Arrays.asList("This is an epic sword!", "Handle with care"))
        .addEnchantment(Enchantment.DAMAGE_ALL, 5)
        .build();
         */
    }
}
