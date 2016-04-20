package com.chaseoes.bettersimplehomes.utilities;

import org.bukkit.Location;

import com.chaseoes.bettersimplehomes.BetterSimpleHomes;

public class SerializableLocation {

    private static String SEPARATOR = "@";

    public static Location stringToLocation(String string) {
        String[] split = string.split("@");
        return new Location(BetterSimpleHomes.getInstance().getServer().getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]));
    }

    public static String locationToString(Location location) {
        return location.getWorld().getName() + SEPARATOR + location.getX() + SEPARATOR + location.getY() + SEPARATOR + location.getZ() + SEPARATOR + location.getYaw() + SEPARATOR + location.getPitch();
    }

}
