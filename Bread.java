public class Bread extends Item {
    
    public Bread(String name){
        super(name, "a loaf of bread", true, true);
    }

    public String useItem(){
        return "You eat some bread. It's a bit stale'.";
    }

    public Item combineWithAnotherItem(Item item){
        return null;
    }
}
