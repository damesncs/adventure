import java.util.ArrayList;

public class TakeItem extends Command {

    public TakeItem(ArrayList<String> nouns){
        super(nouns);
    }

    public String run(GameState state){
        try{
            Item i = state.map.getCurrentRoom().takeItemFromRoom(getNouns().get(0));
            if(i != null){
                state.playerInventory.add(i);
                return "You take the " + i.getName();
            } else {
                return "No such item to take.";
            }
        } catch(IndexOutOfBoundsException e){
            return "no item name entered";
        }
    }

    public static String getNounHelp(){
        return "[item]";
    }

    public static String getHelp(){
        return "[item] - pick up the item";
    }

}
