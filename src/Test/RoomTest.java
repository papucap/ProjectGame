package Test;

import Game.Room;
import Items.Item;
import NPC.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RoomTest {

    private Room room;
    private NPC npc;
    private Item item;

    @BeforeEach
    public void setUp() {
        room = new Room("Test Room");
        npc = new NPC("Test NPC", new Quest("test Quest"));
        item = new Item("Test Item");
    }

    @Test
    public void testAddNPC() {
        room.addNPC(npc);
        List<NPC> npcs = room.npcs;

        assertEquals(1, npcs.size());
        assertEquals("Test NPC", npcs.get(0).getName());
    }

    @Test
    public void testAddItem() {
        room.addItem(item);
        List<Item> items = room.items;

        assertEquals(1, items.size());
        assertEquals("Test Item", items.get(0).toString());
    }

    @Test
    public void testSetAndGetRoomExit() {
        Room room = new Room("Room A");
        Room nextRoom = new Room("Room B");

        room.setExit("north", nextRoom);

        assertEquals(nextRoom, room.getExit("north"));
        assertNull(room.getExit("south"));
    }
}