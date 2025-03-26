package NPC;

/**
 * Třída reprezentující úkol ve hře.
 */
public class Quest {
    private String description;

    public Quest(String description){
        this.description = description;
    }

    /**
     * Vrací popis úkolu.
     */
    public String getDescription(){
        return description;
    }
}
