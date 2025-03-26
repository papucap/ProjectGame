package Command;

import Items.Inventory;

/**
 * Příkaz pro zobrazení obsahu inventáře.
 */
public class ShowInventory implements Command {
    private Inventory inventory;

    public ShowInventory (Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        inventory.showInventory();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
