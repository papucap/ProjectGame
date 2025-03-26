package Command;

import Game.Movement;

/**
 * Příkaz pro zobrazení informací o hře.
 */
public class Info implements Command {

    Movement movement;

    public Info(Movement movement) {
        this.movement = movement;
    }

    @Override
    public String execute() {
        return movement.read("info.txt");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
