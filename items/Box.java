package items;
import java.util.ArrayList;

import core.Item;

public class Box extends Item {

    private ArrayList<Item> items;
    
    public Box(String name, String desc){
        super(name, desc);
    }

    public void addItem(Item i){
        items.add(i);
    }

    public String listItems(){
        String desc = "";
        for(Item i : items){
            desc += i.describe() + "\n";
        }
        return desc;
    }

    public String useItem(){
        return "The box contains: \n" +  listItems();
    }
}
