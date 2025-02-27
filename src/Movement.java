import java.io.IOException;
import java.util.Scanner;

public class Movement {

    public Movement() {
    }

    public void movement (){
     try {
        World world = new World();
        world.loadWorld("world.csv");

        Scanner scanner = new Scanner(System.in);
        Room currentRoom = world.rooms.values().iterator().next();

        System.out.println("Vítej ve světě! Nacházíš se v místnosti: " + currentRoom.name);

        while (true) {
            System.out.println("Můžeš jít: " + currentRoom.exits.keySet());
            System.out.print("Kam chceš jít? (sever/jih/vychod/zapad nebo exit pro ukončení): ");
            String direction = scanner.nextLine().trim().toLowerCase();

            if (direction.equals("exit")) {
                System.out.println("Ukončuji hru.");
                break;
            }

            Room nextRoom = currentRoom.getExit(direction);
            if (nextRoom != null) {
                currentRoom = nextRoom;
                System.out.println("Přesunul ses do místnosti: " + currentRoom.name);
            } else {
                System.out.println("Tam se jít nedá!");
            }
        }

        scanner.close();
    } catch (IOException e) {
        System.out.println("Chyba při načítání souboru: " + e.getMessage());
    }
}
}
