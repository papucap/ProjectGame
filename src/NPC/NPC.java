package NPC;

public class NPC {
    String name;
    Quest quest;

    public NPC(String name, Quest quest) {
        this.name = name;
        this.quest = quest;
    }

    public void interact() {
        System.out.println(name + ": " + quest.getDescription());
    }

    public String getName() {
        return name;
    }

    public String getQuestDescription() {
        return quest.getDescription();
    }
}
