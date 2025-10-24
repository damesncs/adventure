package commands;
import java.util.ArrayList;

import core.GameState;

public class UseItem extends Command {
    
    public UseItem(ArrayList<String> nouns){
        super(nouns);
    }

    public String run(GameState state){
        return "TODO";
    }

    public static String getHelp(){
        return "uses the item";
    }

    public static String getNounHelp(){
        return "item name";
    }
    
}
