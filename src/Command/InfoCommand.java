package Command;

import Game.Movement;

/**
 * Příkaz pro zobrazení informací o příkazech.
 */
public class InfoCommand implements Command {
    Movement movement;

    public InfoCommand(Movement movement) {
        this.movement = movement;
    }

    @Override
    public String execute() {
        movement.read("commandInfo.txt");
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
