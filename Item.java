public class Item {
    private String name;
    private String desc;
    
    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    
    public String describe(){
        return name + ": " + desc;
    }
    
    public String getName(){
        return name;
    }

    public String useItem(GameState state){
        return "the " + name + "  does something, presumably.";
    }


}