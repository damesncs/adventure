package commands;
import core.GameState;

public class Look extends Command {
    
    public Look(){
        super();
    }

    public static String getHelp(){
        return "describe the current room";
    }

    public String run(GameState state){
        return state.map.describeCurrentRoom();
    }
}
