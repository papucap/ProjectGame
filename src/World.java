import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class World {
    Map<String, Room> rooms = new HashMap<>();

    public void loadWorld(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String roomName = parts[0];
            rooms.putIfAbsent(roomName, new Room(roomName));
        }

        reader.close();
        reader = new BufferedReader(new FileReader(filename));

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            Room room = rooms.get(parts[0]);

            if (!parts[1].isEmpty()) room.setExit("north", rooms.get(parts[1]));
            if (!parts[2].isEmpty()) room.setExit("south", rooms.get(parts[2]));
            if (!parts[3].isEmpty()) room.setExit("east", rooms.get(parts[3]));
            if (!parts[4].isEmpty()) room.setExit("west", rooms.get(parts[4]));
        }

        reader.close();
    }

    public void saveWorld(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (Room room : rooms.values()) {
            writer.write(room.name + "," +
                    (room.getExit("north") != null ? room.getExit("north").name : "") + "," +
                    (room.getExit("south") != null ? room.getExit("south").name : "") + "," +
                    (room.getExit("east") != null ? room.getExit("east").name : "") + "," +
                    (room.getExit("west") != null ? room.getExit("west").name : "") + "\n");
        }

        writer.close();
    }
}
