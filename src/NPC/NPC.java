package NPC;

public class NPC {
    String name;
    Quest quest;

    public NPC(String name, Quest quest) {
        this.name = name;
        this.quest = quest;
    }

    public String getName() {
        return name;
    }

    public String getQuestDescription() {
        return quest.getDescription();
    }
}
