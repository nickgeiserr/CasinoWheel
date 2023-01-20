package me.xplore.engineering_excercise;

import me.xplore.engineering_excercise.commands.AddItem;
import me.xplore.engineering_excercise.commands.WheelCommand;
import me.xplore.engineering_excercise.db.MongoInteraction;
import me.xplore.engineering_excercise.events.OnInventoryClick;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Engineering_excercise extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("started hehe");
        // init's mongodb. self-explanatory lol
        MongoInteraction.init();

        // registers commands
        register_commands();

        // register only event in the program
        getServer().getPluginManager().registerEvents(new OnInventoryClick(), this);

    }

    private void register_commands() {
        this.getCommand("wheel").setExecutor(new WheelCommand());
        this.getCommand("add_item").setExecutor(new AddItem());
    }

    @Override
    public void onDisable() {
    }
}
