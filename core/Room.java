package core;
import java.util.ArrayList;

public class Room {
    private String name;
    private String desc;
    private ArrayList<Door> doors;
    private ArrayList<Item> items;
    
    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.doors = new ArrayList<Door>();
        this.items = new ArrayList<Item>();
    }
    
    public String describe(){
        // `this` is optional
        return desc;
    }
    
    public void addItem(Item i){
        items.add(i);
    }
    
    public String listItems(){
        String itemsDesc = "";
        for(Item i : items){ // "for each" loop
            itemsDesc += i.describe() + "\n";
        }
        return itemsDesc;
    }
    
    // returns an item in the room matching this name and removes it from the room, otherwise returns null
    public Item takeItemFromRoom(String itemName){
        for(Item i : items){
            if(i.getName().equals(itemName)){
                items.remove(i);
                return i;
            }
        }
        return null;
    }
    
    public String listDoors(){
        String doorsDesc = "";
        for(int i = 0; i < doors.size(); i++){
            Door d = doors.get(i);
            doorsDesc += i + ": " + d.describe() + "\n";
        }
        return doorsDesc;
    }
    
    public void addDoorTo(Room r, String doorDesc){
        Door d = new Door(r, doorDesc);
        doors.add(d);
    }
    
    public String describeDoor(int doorNum){
        return doors.get(doorNum).describe();
    }
    
    public Room getAdjoiningRoom(int doorNum){
        return doors.get(doorNum).getOtherRoom();
    }
}