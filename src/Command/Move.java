package Command;
import Game.*;


public class Move implements Command{

    Movement m = new Movement();
    public String execute() {
        m.movement();
        return "";
    }

    public boolean exit() {
        return true;
    }

}
