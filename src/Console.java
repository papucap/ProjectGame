
import Command.*;
import Game.Movement;
import Items.Inventory;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private Inventory inventory;

    public void inicialization(){
        map.put("exit", new Quit());
        map.put("pohyb", new Move());
        map.put("inventar", new ShowInventory(inventory));
    }

    private Scanner scanner = new Scanner(System.in);

    public void doCommand(){
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        if(map.containsKey(command)){
            System.out.println(""+map.get(command).execute());
        }else{
            System.out.println(">> Nondefined command");
        }
    }


    public void start(){
        inicialization();
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}