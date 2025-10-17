import java.util.ArrayList;

public class Go extends Command {
    
    private int doorNum;

    public Go(ArrayList<String> nouns){
        super(nouns);
        try {
            // System.out.println("Go debug: " + nouns);
            doorNum = Integer.parseInt(getNouns().get(0));
        } 
        catch(NumberFormatException e){
            markParseFailed("can't go - that's not a number!");
        }
        catch(IndexOutOfBoundsException e){
            markParseFailed("no door number entered");
        }
    }

    public static String getNounHelp(){
        return "[door #]";
    }

    public static String getHelp(){
        return "go through a door";
    }

    public String run(GameState state){
        try {
            return state.map.goDoor(doorNum);
        }
        catch(IndexOutOfBoundsException e){
            return "not valid door number";
        }
    }
}