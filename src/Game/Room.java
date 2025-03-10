package Game;

import Items.Item;
import NPC.NPC;
import NPC.Quest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Room {
    String name;
    Map<String, Room> exits;
    List<NPC> npcs;
    List<Item> items;

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

    public void interactNPCs() {
        for (NPC npc : npcs) {
            npc.interact();
        }
    }

    public void describeRoom() {
        System.out.println("Nacházíš se v: " + name);
        if (!npcs.isEmpty()) {
            System.out.println("V této lokaci jsou následující postavy:");
            for (NPC npc : npcs) {
                System.out.println("- " + npc.getName() + ": " + npc.getQuestDescription());
            }
        }
    }
}

