package Items;

/**
 * Třída reprezentující položku ve hře.
 */
public class Item {
    public String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }



}
