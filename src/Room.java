import java.util.HashMap;
import java.util.Map;

public class Room {
    String name;
    Map<String, Room> exits;

    public Room(String name) {
        this.name = name;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void printExits() {
        for (Map.Entry<String, Room> entry : exits.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().name);
        }
    }
}
