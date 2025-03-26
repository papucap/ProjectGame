package NPC;

/**
 * Třída reprezentující nehratelnou postavu (NPC) ve hře.
 */
public class NPC {
    String name;
    Quest quest;

    public NPC(String name, Quest quest) {
        this.name = name;
        this.quest = quest;
    }

    /**
     * Vrací název NPC.
     */
    public String getName() {
        return name;
    }

    /**
     * Vrací popis úkolu, který NPC nabízí.
     */
    public String getQuestDescription() {
        return quest.getDescription();
    }
}
