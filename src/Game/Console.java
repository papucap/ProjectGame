package Game;

import Command.*;
import Items.Inventory;
import java.io.*;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private Inventory inventory;
    private Movement movement;
    private Console console;

    public Console(Inventory inventory, Movement movement) {
        this.inventory = inventory;
        this.movement = movement;
    }

    public void inicialization(){
        map.put("exit", new Quit());
        map.put("pohyb", new Move(movement));
        map.put("inventar", new ShowInventory(inventory));
        map.put("vezmi", new PickItem(inventory, movement));
        map.put("odstranit", new DeleteInventory(inventory));
        map.put("odevzdat", new Finish(inventory, movement));
        map.put("napoveda", new Info(movement));
        map.put("info", new InfoCommand(movement));
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

