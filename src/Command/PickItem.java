package Command;

import Game.Movement;
import Game.Room;
import Items.Inventory;
import Items.Item;

/**
 * Příkaz pro vyzvednutí položky z místnosti.
 */
public class PickItem implements Command {
    private Inventory inventory;
    private Movement movement;

    public PickItem(Inventory inventory, Movement movement) {
        this.inventory = inventory;
        this.movement = movement;
    }

    @Override
    public String execute() {
        Room currentRoom = movement.getCurrentRoom();

        System.out.println("Aktuální místnost: " + currentRoom.name);


        if (!currentRoom.items.isEmpty()) {
            Item itemToTake = currentRoom.items.get(0);
            if (inventory.addItem(itemToTake)) {
                return " Vzal jsi " + itemToTake + " z místnosti.";
            } else {
                return "Inventář je plný, nemůžeš vzít " + itemToTake + ".";
            }
        } else {
            return "V této místnosti není žádný item k vzeti.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}


