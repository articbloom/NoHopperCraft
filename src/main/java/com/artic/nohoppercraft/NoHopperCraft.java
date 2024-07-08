package com.artic.nohoppercraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;

public class NoHopperCraft extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("NoHopperCraft has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoHopperCraft has been disabled.");
    }

    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        ItemStack result = event.getInventory().getResult();
        if (result != null && result.getType() == Material.HOPPER) {
            // Disable crafting of hoppers
            event.getInventory().setResult(null);
        }
    }
}