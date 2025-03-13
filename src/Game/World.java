package Game;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import Items.Item;
import NPC.NPC;
import NPC.Quest;

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
            for (int i = 5; i < parts.length; i++) {
                String itemName = parts[i].trim();
                if (!itemName.isEmpty()) {
                    room.addItem(new Item(itemName));
                }
            }
        }
        reader.close();

        rooms.get("Muzeum").addNPC(new NPC("Starý kronikář", new Quest("👋Ahoj👋, Dojdi se podívat do lokace Kúpele, tam zjistíš informace o tom \n co je potřeba abys mi odevzdal správné věci")));
        rooms.get("Hradby").addNPC(new NPC("Místní obchodník", new Quest("👋Zdravím👋 nabizím ti tento krásný Meč, chceš si ho vzít?")));
        rooms.get("Radniční náměstí").addNPC(new NPC("Strážce baziliky", new Quest("👋Zdravím👋, vítej v Bardejove, mám pro tebe výzvu \nDojdi se zeptat Kronikáře do Muzea ten ti řekne víc. \nTaky hledej nějakýho divnýho cizince.")));
        rooms.get("Židovské Suburbium").addNPC(new NPC("Archeolog", new Quest("Koukej na ten krásný starý Klíč, určitě by se ti hodil.")));
        rooms.get("Měšťanské Domy").addNPC(new NPC("Tajemný cizinec", new Quest("Narovinu, nechceš tenhle kompas bráško.")));
        rooms.get("Kúpele").addNPC(new NPC("Starosta", new Quest("👋Ahoj👋, určitě jsi se přišel kvůli věcem, které musíš donést do Muzea \nZnám jen jednu a tu najdeš v Kryptu \n💚Hodně Štěstí💚")));
        rooms.get("Krypta").addNPC(new NPC("???", new Quest("Doporučuju jít nejjižněji v tomto městě.")));

    }
}

