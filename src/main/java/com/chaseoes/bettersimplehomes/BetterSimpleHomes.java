package com.chaseoes.bettersimplehomes;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.chaseoes.bettersimplehomes.utilities.HomeConfiguration;
import com.chaseoes.bettersimplehomes.utilities.SerializableLocation;

public class BetterSimpleHomes extends JavaPlugin {

    private static BetterSimpleHomes instance;

    public static BetterSimpleHomes getInstance() {
        return instance;
    }

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        instance = this;
    }

    public void onDisable() {
        instance = null;
    }

    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (!(cs instanceof Player)) {
            cs.sendMessage("That command is only usable by a player!");
            return true;
        }

        Player player = (Player) cs;
        if (cmnd.getName().equalsIgnoreCase("home")) {
            String locationString = HomeConfiguration.getConfig().getString(player.getUniqueId().toString());
            if (locationString != null) {
                Location location = SerializableLocation.stringToLocation(locationString);
                player.teleport(location);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("home")));
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("nohome")));
            }
        }

        if (cmnd.getName().equalsIgnoreCase("sethome")) {
            HomeConfiguration.getConfig().set(player.getUniqueId().toString(), SerializableLocation.locationToString(player.getLocation()));
            HomeConfiguration.save();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("sethome")));
        }
        return true;
    }

}
