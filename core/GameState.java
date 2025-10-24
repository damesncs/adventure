package core;
import java.util.ArrayList;


public class GameState {
    public Map map;
    
    // public ArrayList<Command> commands;

    private ArrayList<Item> playerInventory;

    GameState(Map map){
        this.map = map;
        this.playerInventory = new ArrayList<Item>();
    }

    /** Returns a reference to an item in the player's inventory matching the given name. 
     * If none exists, returns null
     */
    public Item getItemFromInventory(String itemName){
        for(Item i : playerInventory){
            if(i.getName().equals(itemName)){
                return i;
            }
        }
        return null;
    }

    public void addItemToInventory(Item item){
        playerInventory.add(item);
    }

    public int getInventorySize(){
        return playerInventory.size();
    }

    public ArrayList<Item> getInventory(){
        return playerInventory;
    }

}
