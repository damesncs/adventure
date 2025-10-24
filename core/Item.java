package core;
public class Item {
    private String name;
    private String desc;
    private boolean destroyWhenCombined;
    private boolean destroyWhenUsed;
    
    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
        this.destroyWhenCombined = false;
        this.destroyWhenUsed = false;
    }

    public Item(String name, String desc, boolean destroyWhenCombined, boolean destroyWhenUsed){
        this.name = name;
        this.desc = desc;
        this.destroyWhenCombined = destroyWhenCombined;
        this.destroyWhenUsed = destroyWhenUsed;
    }
    
    public String describe(){
        return name + ": " + desc;
    }
    
    public String getName(){
        return name;
    }

    public boolean getDestroyWhenCombined(){
        return destroyWhenCombined;
    }

    public boolean getDestroyWhenUsed(){
        return destroyWhenUsed;
    }

    public String useItem(GameState state){
        return "the " + name + "  does something, presumably.";
    }

    public Item combineWithAnotherItem(Item item){
        return null;
    }


}