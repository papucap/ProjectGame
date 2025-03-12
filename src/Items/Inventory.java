package Items;

import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    private final int MAX_ITEMS = 3; // Maximální počet itemů

    public boolean addItem(Item item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        } else {
            System.out.println("Inventář je plný!");
            return false;
        }
    }

    public void showInventory() {
        System.out.println("Inventář:");
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }
}