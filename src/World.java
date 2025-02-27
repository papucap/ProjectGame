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
                Room sever = rooms.computeIfAbsent(northRoom, k -> new Room(k));
                room.setExit("sever", sever);
            }
            if (parts.length > 2 && !parts[2].trim().isEmpty()) {
                String southRoom = parts[2].trim();
                Room jih = rooms.computeIfAbsent(southRoom, k -> new Room(k));
                room.setExit("jih", jih);
            }
            if (parts.length > 3 && !parts[3].trim().isEmpty()) {
                String eastRoom = parts[3].trim();
                Room vychod = rooms.computeIfAbsent(eastRoom, k -> new Room(k));
                room.setExit("vychod", vychod);
            }
            if (parts.length > 4 && !parts[4].trim().isEmpty()) {
                String westRoom = parts[4].trim();
                Room zapad = rooms.computeIfAbsent(westRoom, k -> new Room(k));
                room.setExit("zapad", zapad);
            }
        }
        reader.close();
    }

    public void saveWorld(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Room room : rooms.values()) {
            String sever = (room.getExit("sever") != null) ? room.getExit("sever").name : "";
            String jih = (room.getExit("jih") != null) ? room.getExit("jih").name : "";
            String vychod = (room.getExit("vychod") != null) ? room.getExit("vychod").name : "";
            String zapad = (room.getExit("zapad") != null) ? room.getExit("zapad").name : "";

            writer.write(room.name + "," + sever + "," + jih + "," + vychod + "," + zapad);
            writer.newLine();
        }
        writer.close();
    }
}
