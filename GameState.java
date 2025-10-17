import java.util.ArrayList;

public class GameState {
    Map map;
    
    ArrayList<Command> commands;

    ArrayList<Item> playerInventory;

    GameState(Map map){
        this.map = map;
        this.playerInventory = new ArrayList<Item>();
    }
}
