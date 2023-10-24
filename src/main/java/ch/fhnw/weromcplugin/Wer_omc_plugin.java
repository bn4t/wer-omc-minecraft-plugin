package ch.fhnw.weromcplugin;

import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Wer_omc_plugin extends JavaPlugin {

    @Override
    public void onEnable() {

        Path path = new Path(new Location(getServer().getWorld("world"), 0, 2, 0));


        for (int i = 0; i < 3; i++) {
            path.DigDown(1);
            path.DigBackward(1);
            for (int j = 0; j < 15; j++) {
                path.DigBackward(3);
                path.DigRight(20);
                path.DigLeft(40);
                path.DigRight(20);
            }
        }


        new BukkitRunnable() {
            @Override
            public void run() {
                getServer().getLogger().log(java.util.logging.Level.INFO, "Diamonds: " + getDiamondsForCoordinates(path.Coordinates()).size());
            }
        }.runTaskAsynchronously(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public List<Location> getDiamondsForCoordinates(List<Location> locations) {
        List<Location> diamonds = new ArrayList<Location>();
        World world = getServer().getWorld("world");

        for (Location location : locations) {
            Chunk chunk = (new Location(world, location.x(), location.y(), location.z())).getChunk();
            if (!chunk.isLoaded())
            {
                chunk.load();
            }


            // log checked block
            getServer().getLogger().log(java.util.logging.Level.INFO, "Checked block: " + location.toString() + " " + world.getBlockAt(location).getType().toString());

            if (world.getBlockAt(location).getType() == Material.DIAMOND_ORE || world.getBlockAt(location).getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                diamonds.add(location);
            }
        }

        return diamonds;
    }
}
