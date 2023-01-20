package me.xplore.engineering_excercise.commands;

import me.xplore.engineering_excercise.db.MongoInteraction;
import me.xplore.engineering_excercise.gui.WheelGUI;
import me.xplore.engineering_excercise.types.WheelItem;
import me.xplore.engineering_excercise.utils.ItemChooser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WheelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final ItemStack TOKEN = new ItemStack(Material.IRON_NUGGET);

        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }
        Player p = (Player) sender;

        if(!p.getInventory().containsAtLeast(TOKEN, 1)) {
            p.sendMessage(ChatColor.RED + "You dont have the required token to use this command.");
            return true;
        }
        p.getInventory().remove(TOKEN);

        System.out.println("creating");
        WheelGUI gui = new WheelGUI(p.getPlayer());

        System.out.println("opening");
        p.openInventory(gui.getGUI());
        return true;
    }
}
