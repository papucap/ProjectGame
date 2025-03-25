package Test;

import Game.Movement;
import Game.Room;
import Game.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovementTest {

    private Movement movement;
    private Room roomA;
    private Room roomB;

    @BeforeEach
    public void setUp() {
        World world = new World();
        roomA = new Room("Room A");
        roomB = new Room("Room B");
        roomA.setExit("north", roomB);
        movement = new Movement(world);
        movement.currentRoom = roomA;
    }

    @Test
    public void testGetCurrentRoom() {
        assertEquals(roomA, movement.getCurrentRoom());
        movement.currentRoom = roomB;
        assertEquals(roomB, movement.getCurrentRoom());
    }

    @Test
    public void testMoveToNextRoom() {
        movement.currentRoom = roomA;
        movement.movement();

        Room nextRoom = movement.getCurrentRoom().getExit("north");
        assertEquals(roomB, nextRoom);
    }

}