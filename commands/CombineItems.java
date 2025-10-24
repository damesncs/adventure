package commands;
import java.util.ArrayList;

import core.GameState;
import core.Item;

public class CombineItems extends Command {
    
    public CombineItems(ArrayList<String> nouns){
        super(nouns);
        if(nouns.size() == 0) markParseFailed("no items specified");
    }

    public String run(GameState state){
        Item firstItem = state.getItemFromInventory(getNouns().get(0));
        if(firstItem == null) return "You don't have a " + getNouns().get(0) + " in your inventory";

        Item secondItem = state.getItemFromInventory(getNouns().get(1));
        if(secondItem == null) return "You don't have a " + getNouns().get(1) + " in your inventory";

        Item newItem = firstItem.combineWithAnotherItem(secondItem);
        if(newItem == null) return "It doesn't work.";

        // TODO perhaps try it the other way (secondItem.combineWithAnotherItem(firstItem))

        state.addItemToInventory(newItem);
        return "You combine the " + firstItem.getName() +
            " and the " + secondItem.getName() +
            " to create a " + newItem.getName();
    }

    public static String getHelp(){
        return "combines two items to create a new item";
    }

    public static String getNounHelp(){
        return "item names";
    }
}
