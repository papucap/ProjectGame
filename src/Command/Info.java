package Command;

import Game.Console;
import Game.Movement;

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
