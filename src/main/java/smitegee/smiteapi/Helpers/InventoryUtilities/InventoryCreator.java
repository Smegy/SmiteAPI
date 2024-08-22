package smitegee.smiteapi.Helpers.InventoryUtilities;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryCreator {


    public static InventoryBuilder makeInventory(int Slots, Component name) {
        return new InventoryBuilder(Slots, name);
    }

    public static class InventoryBuilder {
        private Inventory inv;

        public InventoryBuilder(int Slots, Component name) {
            inv = Bukkit.createInventory(null, Slots, name);
        }


        public InventoryBuilder addItem(ItemStack item) {
            inv.addItem(item);
            return this;
        }

        public InventoryBuilder setItem(ItemStack item, int Slot) {
            inv.setItem(Slot, item);
            return this;
        }

        public InventoryBuilder removeItem(int Slot) {
            inv.setItem(Slot, null);
            return this;
        }


        public Inventory build(Player player) {
            player.openInventory(inv);

            return inv;
        }

        /*
            Inventory inv = InventoryCreator.makeInventory(36, new Component("Shop"))
            .setItem(Material.STONE, 5);
            .removeItem(5);
            .addItem(Material.DIAMOND);
            .build("SmegieLikeVeggie");
         */
    }
}
