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
import java.util.Arrays;
public class Adventure {

    public static final String SPACE = " ";

    public static void main(String args[]){
        GameState state = new GameState(new Map());

        // basic game loop
        Scanner scn = new Scanner(System.in);
        System.out.println("Text Adventure Game!");
        System.out.println("Enter 'help' to see all available commands. Enter 'quit' to end.");
        while (true){
            System.out.println("Enter command:");
            String input = scn.nextLine();
            if(input.equals("quit")) break;
            Command c = parseUserInput(input);
            if(c.isValid()){
                String result = c.run(state);
                System.out.println(result);
            } else {
                System.out.println(c.getErrorMessage());
            }
        }
        System.out.println("quitting");
    }

    private static Command parseUserInput(String input){
        String cmdToken = getCommandToken(input);

        if(cmdToken.equals(Command.INV)) return new ListInventory();
        if(cmdToken.equals(Command.LOOK)) return new Look();
        if(cmdToken.equals(Command.GO)) return new Go(parseNouns(input));
        if(cmdToken.equals(Command.TAKE)) return new TakeItem(parseNouns(input));
        if(cmdToken.equals(Command.HELP)) return new Help();

        return new Command("Didn't recognize command: " + input);
    }

    private static String getCommandToken(String input){
        if(input.indexOf(SPACE) == -1){
            // input doesn't contain a space
            return input;
        } else {
            // input does contain a space, so return the input, up to the space
            return input.substring(0, input.indexOf(SPACE));
        }
    }

    private static ArrayList<String> parseNouns(String input){
        try{
            String nounsStr = input.substring(input.indexOf(SPACE) + 1);
            return new ArrayList<String>(Arrays.asList(nounsStr.split(SPACE)));
        }
        catch (Exception e){
            return new ArrayList<String>(1);
        }
        
    }
    
    // Command handler methods - private static methods
    // These should return a String, and can accept the String for the noun which was entered
    
    
}