package commands;
import java.util.ArrayList;

import core.GameState;
import core.Item;

public class CombineItems extends Command {
    
    public CombineItems(ArrayList<String> nouns){
        // TODO figure out what to do if nouns is empty
        super(nouns);
    }

    public String run(GameState state){
        if(getNouns().size() > 0){
            Item firstItem = state.getItemFromInventory(getNouns().get(0));
            if(firstItem != null){
                Item secondItem = state.getItemFromInventory(getNouns().get(1));
                if(secondItem != null){
                    Item newItem = firstItem.combineWithAnotherItem(secondItem);
                    if(newItem != null){
                        state.addItemToInventory(newItem);
                        return "You combine the " + firstItem.getName() + " and the " + secondItem.getName() +
                        " to create a " + newItem.getName();
                    }
                    return "It doesn't work.";
                }
                return "You don't have a " + getNouns().get(1) + " in your inventory";
            }
            return "You don't have a " + getNouns().get(0) + " in your inventory";
        }
        return "no items specified"; // TODO ideally this is checked when we parse the input
    }

    public static String getHelp(){
        return "combines two items to create a new item";
    }

    public static String getNounHelp(){
        return "item names";
    }
}
