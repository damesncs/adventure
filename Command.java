public class Command {
    
    // static constants - recognized command strings
    public static final String LOOK = "look";
    public static final String GO = "go";
    public static final String TAKE = "take";
    public static final String DROP =  "drop";
    public static final String INV = "inv";
    
    
    // private instance variables (fields)
    private String verb;
    private String noun; // we could expand this to be a list (array)
    private boolean parsedSuccessfully;
    private String errorMessage;
    
    // private constructor
    //   use the parseFromString method to create new Command objects
    private Command(String verb, String noun, boolean parsed, String err){
        this.verb = verb;
        this.noun = noun;
        this.parsedSuccessfully = parsed;
        this.errorMessage = err;
    }
    
    // accessor methods - strictly speaking the `this` is optional
    public String getVerb(){
        return this.verb;
    }
    
    // simple method to help  Adventure.doCommand() match user input with recognized command strings,
    //    i.e., the constants defined at the top of this class
    public boolean is(String commandConstant){
        return this.verb.equals(commandConstant);
    }
    // accessor method
    public String getNoun(){
        return this.noun;
    }
    
    // accessor 
    public boolean isValid(){
        return parsedSuccessfully;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }
    
    // static method - a "factory" method which creates an object from a string
    public static Command parseFromString(String s){
        if(s.indexOf(" ") > 0){
            // command with a space - verb + noun
            String v = s.substring(0, s.indexOf(" "));
            String n = s.substring(s.indexOf(" ") + 1);
            return new Command(v, n, true, "");
        } else if(s.length() > 0){
            // command without a space - verb only
            return new Command(s, "", true, "");
        }
        return new Command("", "", false, "Couldn't parse command.");
    }
    
     // Later on in the year we can use inheritance and arrays to make this less tedious.
    public static String getHelp(){
        return
            "Commands: \n" 
            + "look - describe the current room \n"
            + "go [door #] - go through a door \n"
            + "take [item] - pick up an item. \n"
            + "inv - show items in inventory \n"
            + "drop [item] - remove item from inventory \n"
        ;
    }
    
}