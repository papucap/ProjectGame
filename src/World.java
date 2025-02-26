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
            if (parts.length < 1) continue;

            String roomName = parts[0].trim();
            Room room = rooms.computeIfAbsent(roomName, k -> new Room(k));

            if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                String northRoom = parts[1].trim();
                Room north = rooms.computeIfAbsent(northRoom, k -> new Room(k));
                room.setExit("north", north);
            }
            if (parts.length > 2 && !parts[2].trim().isEmpty()) {
                String southRoom = parts[2].trim();
                Room south = rooms.computeIfAbsent(southRoom, k -> new Room(k));
                room.setExit("south", south);
            }
            if (parts.length > 3 && !parts[3].trim().isEmpty()) {
                String eastRoom = parts[3].trim();
                Room east = rooms.computeIfAbsent(eastRoom, k -> new Room(k));
                room.setExit("east", east);
            }
            if (parts.length > 4 && !parts[4].trim().isEmpty()) {
                String westRoom = parts[4].trim();
                Room west = rooms.computeIfAbsent(westRoom, k -> new Room(k));
                room.setExit("west", west);
            }
        }
        reader.close();
    }

    public void saveWorld(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Room room : rooms.values()) {
            String north = (room.getExit("north") != null) ? room.getExit("north").name : "";
            String south = (room.getExit("south") != null) ? room.getExit("south").name : "";
            String east = (room.getExit("east") != null) ? room.getExit("east").name : "";
            String west = (room.getExit("west") != null) ? room.getExit("west").name : "";

            writer.write(room.name + "," + north + "," + south + "," + east + "," + west);
            writer.newLine();
        }
        writer.close();
    }
}
