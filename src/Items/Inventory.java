package Items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public List<Item> items = new ArrayList<>();
    private final int MAX_ITEMS = 3;

    public boolean addItem(Item item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        } else {
            System.out.println("Inventář je plný!");
            return false;
        }
    }

    public void removeItem() {
        items.clear();
    }

    public void showInventory() {
        System.out.println("Inventář:");
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }
}