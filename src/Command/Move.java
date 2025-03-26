package Command;
import Game.*;

/**
 * Příkaz pro pohyb mezi místnostmi.
 */
public class Move implements Command{
    private Movement movement;

    public Move(Movement movement) {
        this.movement = movement;
    }

    public String execute() {
        movement.movement();

        return "";
    }

    public boolean exit() {
        return true;
    }

}
