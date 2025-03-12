package Command;

import Game.Movement;
import Game.Room;
import Game.Console;
import Items.Inventory;
import Items.Item;

public class PickItem implements Command {
    private Inventory inventory;
    private Movement movement;

    public PickItem(Inventory inventory, Movement movement) {
        this.inventory = inventory;
        this.movement = movement;
    }

    @Override
    public String execute() {
        Room currentRoom = movement.getCurrentRoom(); // Získání aktuální místnosti

        System.out.println("Aktuální místnost: " + currentRoom.name); // Debug výpis
        System.out.println("Položky v místnosti: " + currentRoom.items.size()); // Debug výpis

        if (!currentRoom.items.isEmpty()) {
            Item itemToTake = currentRoom.items.get(0);
            if (inventory.addItem(itemToTake)) {
                currentRoom.removeItem(itemToTake);
                return "Vzal jsi " + itemToTake + " z místnosti.";
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


