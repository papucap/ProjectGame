package Command;

import Items.Inventory;
import Items.Item;

public class DeleteInventory implements Command {
    private Inventory inventory;

    public DeleteInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        inventory.removeItem();
        return "Položky Smazány z inventáře!!!";
    }

    @Override
    public boolean exit() {
        return true;
    }
}

