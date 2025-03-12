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
/*
            if (roomName.equals("Radniční náměstí")) {
                room.addItem(new Item("Mapka"));
            } else if (roomName.equals("Muzeum")) {
                room.addItem(new Item("Zlatý prsten"));
            } else if (roomName.equals("Hradby")) {
                room.addItem(new Item("Meč"));
            } else if (roomName.equals("Krypta")) {
                room.addItem(new Item("Starý klíč"));
            } else if (roomName.equals("Měšťanské Domy")) {
                room.addItem(new Item("Kniha"));
            }
*/
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

        rooms.get("Muzeum").addNPC(new NPC("Starý kronikář", new Quest("Potřebuje donést zlatý prsten")));
        rooms.get("Hradby").addNPC(new NPC("Místní obchodník", new Quest("Dones mi prosím Medailon")));
        rooms.get("Radniční náměstí").addNPC(new NPC("Strážce baziliky", new Quest("Bez se podívat do židovského suburbia")));
        rooms.get("Židovské Suburbium").addNPC(new NPC("Archeolog", new Quest("Ahoj tady máš krabici, tu dones nějakému cizincovi")));
        rooms.get("Měšťanské Domy").addNPC(new NPC("Tajemný cizinec", new Quest("Dones mi Krabici")));

        /*rooms.get("Muzeum").addItem(new Item("Kniha"));
        rooms.get("Radniční náměstí").addItem(new Item("Mapka"));
        rooms.get("Krypta").addItem(new Item("Prsten"));
        rooms.get("Hradby").addItem(new Item("Mec"));
        rooms.get("Židovské Suburbium").addItem(new Item("Klic"));

         */
    }
}

