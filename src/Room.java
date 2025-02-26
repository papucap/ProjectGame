import java.io.*;
import java.util.*;

public class Room {
    String name;
    Map<String, Room> exits = new HashMap<>();

    public Room(String name) {
        this.name = name;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
