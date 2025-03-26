package Command;

import Items.Inventory;
import Items.Item;

/**
 * Příkaz pro odstranění všech položek z inventáře.
 */
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

