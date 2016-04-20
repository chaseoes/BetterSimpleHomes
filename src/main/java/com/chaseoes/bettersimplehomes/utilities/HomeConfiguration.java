package com.chaseoes.bettersimplehomes.utilities;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import com.chaseoes.bettersimplehomes.BetterSimpleHomes;

public class HomeConfiguration {
    
    private static File customConfigFile = null;
    private static final String fileName = "homes.yml";
    private static FileConfiguration customConfig = null;

    public static FileConfiguration getConfig() {
        if (customConfig == null) {
            reload();
        }
        return customConfig;
    }

    public static void reload() {
        if (customConfigFile == null) {
            customConfigFile = new File(BetterSimpleHomes.getInstance().getDataFolder(), fileName);
        }

        customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
    }

    public static void save() {
        if (customConfig == null || customConfigFile == null) {
            return;
        }

        try {
            getConfig().save(customConfigFile);
        } catch (IOException ex) {

        }
    }

}
