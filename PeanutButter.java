public class PeanutButter extends Item {
    
    public PeanutButter(String name){
        super(name, "a jar of peanut butter", false, false);
    }

    public String useItem(){
        return "You eat some peanut butter. It is delicious.";
    }

    public Item combineWithAnotherItem(Item item){
        if(item instanceof Bread){
            return new Sandwich("peanut butter sandwich", "a delicious and nutritious snack");
        }
        return null;
    }
}
