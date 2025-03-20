package Game;

import Items.Item;
import NPC.NPC;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    public String name;
    Map<String, Room> exits;
    public List<NPC> npcs;
    public List<Item> items;

    public Room(String name) {
        this.name = name;
        this.exits = new HashMap<>();
        this.npcs = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public void addItem(Item item) {
        items.add(item);
    }




    public void describeRoom() {
        System.out.println(" ");
        System.out.println("📍Nacházíš se v: " + name + "📍");
        if (!npcs.isEmpty()) {
            System.out.println("🧙‍♂️️V této lokaci jsou následující postavy:🧙‍");
            for (NPC npc : npcs) {
                System.out.println("- " + npc.getName() + ":\n" + npc.getQuestDescription());
            }
        }
        if (!items.isEmpty()) {
            System.out.println(" ");
            System.out.println("💎V této místnosti jsou následující itemy:💎");
            for (Item item : items) {
                System.out.println("- " + item);
                System.out.println(" ");
            }
        }
    }
}

