package Test;

import Items.Inventory;
import Items.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testInventoryFull() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Item 1"));
        inventory.addItem(new Item("Item 2"));
        inventory.addItem(new Item("Item 3"));

        boolean result = inventory.addItem(new Item("Item 4"));

        assertFalse(result);
        assertEquals(3, inventory.items.size());
    }


    @Test
    public void testRemoveItemsFromInventory() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Item 1"));
        inventory.addItem(new Item("Item 2"));

        inventory.removeItem();

        assertEquals(0, inventory.items.size());
    }


}