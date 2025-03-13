import Game.Console;
import Game.Movement;

import Game.World;
import Items.Inventory;

public class TextGameWorld {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        World world = new World();
        Movement movement = new Movement(world);
        Console c = new Console(inventory, movement);
        System.out.println(movement.read("info.txt"));
        c.start();
    }
}


