public class Sandwich extends Item {
    
    public Sandwich(String name, String desc){
        super(name, desc, false, true);
    }

    public String useItem(){
        return "You eat the sandwich";
    }
}
