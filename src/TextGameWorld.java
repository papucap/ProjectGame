import Game.Console;
import Game.Movement;
import Game.Room;
import Items.Inventory;

public class TextGameWorld {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Movement movement = new Movement();
        Console c = new Console(inventory, movement);
        c.start();
    }
}


