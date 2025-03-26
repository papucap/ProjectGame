package Test;

import Game.Movement;
import Game.Room;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro Movement.
 */
public class MovementTest {

    private Movement movement;
    private Room roomA;
    private Room roomB;

    /**
     * Před každým testem se nastaví nový svět a místnosti.
     */
    @BeforeEach
    public void setUp() {
        World world = new World();
        roomA = new Room("Room A");
        roomB = new Room("Room B");
        roomA.setExit("north", roomB);
        movement = new Movement(world);
        movement.currentRoom = roomA;
    }

    /**
     * Testuje, zda se správně vrací aktuální místnost.
     */
    @Test
    public void testGetCurrentRoom() {
        assertEquals(roomA, movement.getCurrentRoom());
        movement.currentRoom = roomB;
        assertEquals(roomB, movement.getCurrentRoom());
    }

    /**
     * Testuje, zda se správně pohybuje do další místnosti.
     */
    @Test
    public void testMoveToNextRoom() {
        movement.currentRoom = roomA;
        movement.movement();

        Room nextRoom = movement.getCurrentRoom().getExit("north");
        assertEquals(roomB, nextRoom);
    }

}