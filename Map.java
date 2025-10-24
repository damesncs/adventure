public class Map {
    
    private Room startRoom;
    private Room currentRoom;
    
    public Map(){
        // set up the rooms in the map
        Room blueRoom = new Room("Blue room", "a room with blue walls.");
        this.startRoom = blueRoom;
        this.currentRoom = this.startRoom;
        
        Item paperclip = new Item("paperclip", "a normal paperclip");
        blueRoom.addItem(paperclip);
        
        Room redRoom = new Room("Red room", "a room with red walls.");
        blueRoom.addDoorTo(redRoom, "dusty door");
        redRoom.addDoorTo(blueRoom, "wooden door");
        
        // add more rooms to build out the game here:
        
        
    }
    
    public Room getStartingRoom(){
        return startRoom;
    }
    
    public Room getCurrentRoom(){
        return currentRoom;
    }
    
    public String describeCurrentRoom(){
        return
        "You are in " + currentRoom.describe() + "\n"
        + "   You see: \n" + currentRoom.listItems()
        + "   You can go: \n" + currentRoom.listDoors()
        ;
    }
    
    public String goDoor(int doorNum){
        String doorDesc = this.currentRoom.describeDoor(doorNum);
        this.currentRoom = this.currentRoom.getAdjoiningRoom(doorNum);
        return "You go through the " + doorDesc;
    }
    

}