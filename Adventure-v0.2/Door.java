public class Door {
    
    private Room room;
    private String desc;
    
    public Door(Room r, String desc){
        room = r;
        this.desc = desc;
    }
    
    public String describe(){
        return desc;
    }
    
    public Room getOtherRoom(){
        return room;
    }
}