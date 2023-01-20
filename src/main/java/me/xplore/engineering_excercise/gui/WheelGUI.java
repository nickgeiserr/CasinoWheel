package me.xplore.engineering_excercise.gui;

import me.xplore.engineering_excercise.db.MongoInteraction;
import me.xplore.engineering_excercise.types.WheelItem;
import me.xplore.engineering_excercise.utils.ItemChooser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Random;

public class WheelGUI {
    private static final int GUI_SIZE = 9;
    private static final String GUI_NAME = "Spinning Wheel";
    private Inventory gui;
    private Random random = new Random();

    public WheelGUI(Player p) {
        System.out.println("gui made");
        gui = Bukkit.createInventory(p, GUI_SIZE, GUI_NAME);

        System.out.println("wheel item updated");
        update_wheel_item(gui);
        System.out.println("gray spots filled");
        fill_wheel_gray_spots(gui);
        System.out.println("spin buttons filled");
        fill_spin_buttons(gui);
    }

    public static void update_wheel_item(Inventory wheel_gui) {
        WheelItem chosen_item = ItemChooser.chooseItem(MongoInteraction.getWheelItems());
        ItemStack stack = new ItemStack(Material.valueOf(chosen_item.item_val));
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "Possible Item...");
        stack.setItemMeta(itemMeta);

        wheel_gui.setItem(5, stack);
    }

    public static void fill_spin_buttons(Inventory wheel_gui) {
        ItemStack spin_button = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta itemMeta = spin_button.getItemMeta();
        itemMeta.setDisplayName(ChatColor.AQUA + "Spin!");
        spin_button.setItemMeta(itemMeta);

        wheel_gui.setItem(4, spin_button);
        wheel_gui.setItem(6, spin_button);
    }

    public static void fill_wheel_gray_spots(Inventory wheel_gui) {
        ItemStack empty_space = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = empty_space.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GRAY + "Empty Space");
        empty_space.setItemMeta(itemMeta);

        wheel_gui.setItem(0, empty_space);
        wheel_gui.setItem(1, empty_space);
        wheel_gui.setItem(2, empty_space);
        wheel_gui.setItem(7, empty_space);
        wheel_gui.setItem(8, empty_space);
        wheel_gui.setItem(9, empty_space);
    }

    public Inventory getGUI() {
        return gui;
    }
}
