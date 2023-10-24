package ch.fhnw.weromcplugin;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<org.bukkit.Location> coordinates = new ArrayList<>();
    private org.bukkit.Location currentLocation;


    public Path(org.bukkit.Location start) {
        this.currentLocation = start;

        coordinates.add(start);

    }

    public List<Location> Coordinates() {
        return coordinates;
    }

    public void DigDown(int amount) {
        for (int i = 0; i < amount; i++) {
            Location loc = new Location(currentLocation.getWorld(), currentLocation.getX(), currentLocation.getY() - 1, currentLocation.getZ());
            coordinates.add(loc);
            addSurroundingLocations(loc);

            currentLocation = loc;
        }
    }

    public void DigUp(int amount) {
        for (int i = 0; i < amount; i++) {

            Location loc = new Location(currentLocation.getWorld(), currentLocation.getX(), currentLocation.getY() + 1, currentLocation.getZ());
            addSurroundingLocations(loc);

            currentLocation = loc;
        }
    }

    public void DigLeft(int amount) {
        for (int i = 0; i < amount; i++) {

            Location loc = new Location(currentLocation.getWorld(), currentLocation.getX(), currentLocation.getY(), currentLocation.getZ() + 1);
            addSurroundingLocations(loc);

            currentLocation = loc;
        }
    }

    public void DigRight(int amount) {
        for (int i = 0; i < amount; i++) {

            Location loc = new Location(currentLocation.getWorld(), currentLocation.getX(), currentLocation.getY(), currentLocation.getZ() + 1);
            addSurroundingLocations(loc);

            currentLocation = loc;
        }
    }

    public void DigForward(int amount) {
        for (int i = 0; i < amount; i++) {

            Location loc = new Location(currentLocation.getWorld(), currentLocation.getX() + 1, currentLocation.getY(), currentLocation.getZ());
            addSurroundingLocations(loc);

            currentLocation = loc;
        }
    }

    public void DigBackward(int amount) {
        for (int i = 0; i < amount; i++) {

            Location loc = new Location(currentLocation.getWorld(), currentLocation.getX() - 1, currentLocation.getY(), currentLocation.getZ());
            addSurroundingLocations(loc);

            currentLocation = loc;
        }
    }


    private void addSurroundingLocations(Location start) {
        coordinates.add(new Location(start.getWorld(), start.getX() + 1, start.getY(), start.getZ()));
        coordinates.add(new Location(start.getWorld(), start.getX() - 1, start.getY(), start.getZ()));
        coordinates.add(new Location(start.getWorld(), start.getX(), start.getY() + 1, start.getZ()));
        coordinates.add(new Location(start.getWorld(), start.getX(), start.getY() - 1, start.getZ()));
        coordinates.add(new Location(start.getWorld(), start.getX(), start.getY(), start.getZ() + 1));
        coordinates.add(new Location(start.getWorld(), start.getX(), start.getY(), start.getZ() - 1));
    }

}
