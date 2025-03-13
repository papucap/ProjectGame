package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Movement {
    private World world;
    private Room currentRoom;

    private boolean firstMove = true;


    public Movement(World world) {
        try {
            this.world = world;
            world = new World();
            world.loadWorld("world.csv");
            currentRoom = world.rooms.get("Radniční náměstí");

            if (currentRoom == null) {
                System.out.println("Chyba: Místnost 'Radniční náměstí' nebyla nalezena!");
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání souboru: " + e.getMessage());
        }
    }

    public void movement() {
        if (currentRoom == null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);

        if (firstMove) {
            System.out.println("Vítej ve světě!");
            System.out.println(" ");
            currentRoom.describeRoom();
            firstMove = false;
        }

        System.out.println("Můžeš jít: " + currentRoom.exits.keySet());
        System.out.print("Kam chceš jít? (sever/jih/východ/západ nebo exit pro ukončení): ");
        String direction = scanner.nextLine().trim().toLowerCase();

        if (direction.equals("exit")) {
            System.out.println(" ");
            return;
        }

        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("Přesunul ses do místnosti: " + currentRoom.name);
            currentRoom.describeRoom();
        } else {
            System.out.println("Tam se jít nedá!");
        }
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public String read(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }
        return " ";
    }
    
}

