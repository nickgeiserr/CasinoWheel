package me.xplore.engineering_excercise.commands;

import me.xplore.engineering_excercise.db.MongoInteraction;
import me.xplore.engineering_excercise.types.WheelItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class AddItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String item_val = args[0];
        Integer chance = Integer.parseInt(args[1]);
        if(item_val != null && chance != null) {
            WheelItem new_item = new WheelItem(item_val, chance);
            MongoInteraction.writeItem(new_item);
            return true;
        }
        return true;
    }
}
