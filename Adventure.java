// a simple text adventure game to demonstrate class design concepts:

// access modifiers: public / private
// static vs instance: methods and fields
// constructors
// accessor methods

// To add a new command:
// 1. Add a new constant (public static final String) to Command
// 2. Add a handler method to Adventure (preferably named `handle...`)
// 3. Map the command to the handler method in doCommand() 

import java.util.Scanner;
import java.util.ArrayList;
public class Adventure {
    
    private static Map map;
    
    private static ArrayList<Item> playerInventory;
    
    public static void main(String args[]){
        map = new Map();
        playerInventory = new ArrayList<Item>();
        
        // basic game loop
        Scanner scn = new Scanner(System.in);
        System.out.println("Text Adventure Game!");
        System.out.println("Enter 'help' to see all available commands");
        while (true){
            System.out.println("Enter command:");
            String input = scn.nextLine();
            if(input.equals("quit")) break;
            if(input.equals("help")) { System.out.println(Command.getHelp()); continue; }
            Command c = Command.parseFromString(input);
            if(c.isValid()){
                String result = doCommand(c);
                System.out.println(result);
            } else {
                System.out.println(c.getErrorMessage());
            }
        }
        System.out.println("quitting");
    }
    
    // process the command (match the command with a handler method)
    private static String doCommand(Command c){
        if (c.is(Command.LOOK)){
            return handleLook();
        }
        else if (c.is(Command.GO)){
            return handleGo(c.getNoun());
        } 
        else if (c.is(Command.TAKE)){
            return handleTake(c.getNoun());
        }
        else if (c.is(Command.INV)){
            return handleInv();
        }
        else if(c.is(Command.DROP)){
            return handleDrop(c.getNoun());
        }
        else {
            // un-implemented command
            return "Can't " + c.getVerb() + " - Command not recognized.";
        }
    }
    
    // Command handler methods - private static methods
    // These should return a String, and can accept the String for the noun which was entered
    
    private static String handleLook(){
        return map.describeCurrentRoom();
    }
    
    private static String handleGo(String noun){
        int doorNum = Integer.parseInt(noun);
        return map.goDoor(doorNum);
    }
    
    private static String handleTake(String noun){
        Item i = map.getCurrentRoom().takeItemFromRoom(noun);
        if(i != null){
            playerInventory.add(i);
            return "You take the " + i.getName();
        } else {
            return "No such item to take.";
        }
    }
    
    private static String handleInv(){
        String invStr = "Your inventory: \n";
        if(playerInventory.size() == 0){
            invStr = "Nothing in inventory.";
        } else {
            for(Item i : playerInventory){
                invStr += i.describe() + "\n";
            }
        }
        return invStr;
    }
    
    private static String handleDrop(String noun){
        // TODO remove the item object from playerInventory and add to room
        return "You drop the " + noun;
    }
    
}