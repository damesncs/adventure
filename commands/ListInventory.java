package commands;
import core.GameState;
import core.Item;

public class ListInventory extends Command {

    public ListInventory(){
        super();
    }

    public static String getHelp(){
        return "lists items in inventory";
    }

    public String run(GameState state){
        String invStr = "Your inventory: \n";
        if(state.getInventorySize() == 0){
            invStr = "Nothing in inventory.";
        } else {
            for(Item i : state.getInventory()){
                invStr += i.describe() + "\n";
            }
        }
        return invStr;
    }

}