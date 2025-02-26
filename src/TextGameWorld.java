import java.io.IOException;

public class TextGameWorld {
    public static void main(String[] args) {
        try {
            World world = new World();
            world.loadWorld("world.csv");

            System.out.println("NAČTENÝ SVĚT:");
            for (String roomName : world.rooms.keySet()) {
                Room room = world.rooms.get(roomName);
                System.out.println("\nMístnost: " + roomName);
                room.printExits();
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání souboru: " + e.getMessage());
        }
    }
}
