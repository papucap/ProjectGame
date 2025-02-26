import java.io.IOException;

public class TextGameWorld {
    public static void main(String[] args) throws IOException {
        World world = new World();
        world.loadWorld("world.csv");

        // Testovací výpis
        for (String roomName : world.rooms.keySet()) {
            System.out.println("Místnost: " + roomName);
            for (String direction : new String[]{"north", "south", "east", "west"}) {
                Room exit = world.rooms.get(roomName).getExit(direction);
                if (exit != null) {
                    System.out.println("  " + direction + " -> " + exit.name);
                }
            }
        }
    }
}
