package me.xplore.engineering_excercise.events;

import me.xplore.engineering_excercise.db.MongoInteraction;
import me.xplore.engineering_excercise.types.WheelItem;
import me.xplore.engineering_excercise.utils.ItemChooser;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class OnInventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(current == null) return;

        if(event.getView().getTitle() == "Spinning Wheel") {

            event.setCancelled(true);

            if(current.getType() == Material.GREEN_STAINED_GLASS_PANE) {
                WheelItem chosen_item = ItemChooser.chooseItem(MongoInteraction.getWheelItems());
                ItemStack stack = new ItemStack(Material.valueOf(chosen_item.item_val));

                player.getInventory().addItem(stack);

                player.sendMessage(ChatColor.GREEN + "Enjoy your prize!");
                player.spawnParticle(Particle.FLASH, player.getLocation(), 1);

                player.closeInventory();
            }


        }
    }
}
