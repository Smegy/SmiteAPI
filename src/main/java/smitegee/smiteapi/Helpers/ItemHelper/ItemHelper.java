package smitegee.smiteapi.Helpers.ItemHelper;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
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

        /**
         *
         * @param mat The Material you want the item to be
         * @param amount The amount of the item you want
         */

        public ItemBuilder(Material mat, int amount) {
            this.item = new ItemStack(mat, amount);
            this.meta = item.getItemMeta();
        }

        /**
         *
         * @param name The simple name you want to set
         * @return Return's this.
         */
        public ItemBuilder setName(String name) {
            if (meta != null) {
                meta.setDisplayName(name);
            }
            return this;
        }

        /**
         *
         * @param name The Advanced name (Component)
         * @return Return's this.
         */

        public ItemBuilder advancedName(Component name) {
            if (meta != null) {
                meta.displayName(name);
            }
            return this;
        }

        /**
         *
         * @param lore The lore you want to set
         * @return Return's this.
         */

        public ItemBuilder setLore(List<String> lore) {
            if (meta != null) {
                meta.setLore(lore);
            }
            return this;
        }

        /**
         *
         * @param enchantment The enchantment you want to add.
         * @param level The level of enchantment you want to add
         * @return Return's this.
         */

        public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
            item.addUnsafeEnchantment(enchantment, level);
            return this;
        }

        /**
         *
         * @param enchantment The enchantment you want to remove
         * @return Return's this.
         */

        public ItemBuilder removeEnchantment(Enchantment enchantment) {
            item.removeEnchantment(enchantment);
            return this;
        }

        /**
         *
         * @param itemFlag The ItemFlag you want to add
         * @return Return's this.
         */

        public ItemBuilder addItemFlag(ItemFlag itemFlag) {
            item.addItemFlags(itemFlag);
            return this;
        }

        /**
         *
         * @param itemFlag The ItemFlag you want to remove
         * @return Return's this.
         */

        public ItemBuilder removeItemFlag(ItemFlag itemFlag) {
            item.removeItemFlags(itemFlag);
            return this;
        }

        /**
         *
         * @return Return's "this" but sets the item to unbreakable
         */

        public ItemBuilder setUnbreakable() {
            setUnbreakable();
            return this;
        }

        /**
         *
         * @return Returns the item and builds it (obviously)
         */



        public ItemStack build() {
            if (meta != null) {
                item.setItemMeta(meta);
            }
            return item;
        }

        /*
        ItemStack myItem = ItemHelper.makeItem(Material.DIAMOND_SWORD, 1)
        .setName("Epic Sword")
        .advancedName(Component.text("Epic Sword but cool", TextColor(255, 255, 255)))
        .setLore(Arrays.asList("This is an epic sword!", "Handle with care"))
        .addEnchantment(Enchantment.DAMAGE_ALL, 5)
        .build();
         */
    }

}
