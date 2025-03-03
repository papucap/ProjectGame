package Items;

public class PickItem {
    private Inventory inventory;
    private Item item;

    public PickItem(Inventory inventory, Item item) {
        this.inventory = inventory;
        this.item = item;
    }

    public void execute() {
        inventory.addItem(item);
    }

}
