package Command;

import Game.Movement;

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
