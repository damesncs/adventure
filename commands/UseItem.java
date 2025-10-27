package commands;
import java.util.ArrayList;

import core.GameState;
import core.Item;

public class UseItem extends Command {
    
    public UseItem(ArrayList<String> nouns){
        super(nouns);
        if(nouns.size() == 0) markParseFailed("no item specified");
    }

    public String run(GameState state){
        Item i = state.getItemFromInventory(getNouns().get(0));
        if(i != null) {
            if(i.getDestroyWhenUsed()) state.removeItemFromInventory(i);
            return i.useItem(state);
        }
        return "You don't have a " + getNouns().get(0) + " to use.";
    }

    public static String getHelp(){
        return "uses the item";
    }

    public static String getNounHelp(){
        return "item name";
    }

    
}
