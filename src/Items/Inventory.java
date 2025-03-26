package Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující inventář hráče.
 */
public class Inventory {
    public List<Item> items = new ArrayList<>();
    private final int MAX_ITEMS = 3;

    /**
     * Přidává položku do inventáře.
     *
     * @param item položka, kterou se má přidat.
     * @return true, pokud byla položka úspěšně přidána, jinak false.
     */
    public boolean addItem(Item item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        } else {
            System.out.println("Inventář je plný!");
            return false;
        }
    }

    /**
     * Odstraňuje všechny položky z inventáře.
     */
    public void removeItem() {
        items.clear();
    }

    /**
     * Zobrazuje obsah inventáře.
     */
    public void showInventory() {
        System.out.println("Inventář:");
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }
}