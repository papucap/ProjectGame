package Command;
import Game.Movement;
import Game.Room;
import Items.Inventory;

/**
 * Příkaz pro dokončení hry.
 */
public class Finish implements Command {
    private Inventory inventory;
    private Movement movement;

    public Finish(Inventory inventory, Movement movement) {
        this.inventory = inventory;
        this.movement = movement;
    }

    @Override
    public String execute() {

        Room currentRoom = movement.getCurrentRoom();

        if (currentRoom.name.equals("Muzeum")) {

            if (inventory.items.stream().anyMatch(item -> item.name.equals("Kompas🧭")) &&
                    inventory.items.stream().anyMatch(item -> item.name.equals("Prsten💍")) &&
                    inventory.items.stream().anyMatch(item -> item.name.equals("Klic🗝"))) {

                inventory.removeItem();
                System.exit(0);
                return "Hra byla dohrána!";
            }
        }


        return "Špatně, smaž si inventář a zkus to znovu.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}