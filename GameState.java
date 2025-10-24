import java.util.ArrayList;

public class GameState {
    Map map;
    
    ArrayList<Command> commands;

    ArrayList<Item> playerInventory;

    GameState(Map map){
        this.map = map;
        this.playerInventory = new ArrayList<Item>();
    }

    /** Returns a reference to an item in the player's inventory matching the given name. 
     * If none exists, returns null
     */
    Item getItemFromInventory(String itemName){
        for(Item i : playerInventory){
            if(i.getName().equals(itemName)){
                return i;
            }
        }
        return null;
    }

    void addItemToInventory(Item item){
        playerInventory.add(item);
    }


}
