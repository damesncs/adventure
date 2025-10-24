import java.util.ArrayList;

public class Command {

    public static final String HELP = "help";
    public static final String LOOK = "look";
    public static final String GO = "go";
    public static final String TAKE = "take";
    public static final String DROP =  "drop";
    public static final String INV = "inv";
    public static final String USE = "use";
    public static final String COMBINE = "combine";

    private ArrayList<String> nouns;
    private boolean parsedSuccessfully;
    private String errorMessage;

    public Command(ArrayList<String> nouns){
        this.nouns = nouns;
        this.parsedSuccessfully = true;
        this.errorMessage = "";
    }

    public Command(String errorMessage){
        this.nouns = null;
        this.parsedSuccessfully = false;
        this.errorMessage = errorMessage;
    }

    public Command(){
        this.nouns = new ArrayList<String>(1);
        this.parsedSuccessfully = true;
        this.errorMessage = "";
    }

    public String run(GameState state){
        return "nothing happens";
    }

    public static String getHelp(){
        return "default command - does nothing";
    }

    public static String getNounHelp(){
        return "";
    }
    
    public boolean isValid(){
        return parsedSuccessfully;
    }

    public void markParseFailed(String message){
        this.parsedSuccessfully = false;
        this.errorMessage = message;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }

    public ArrayList<String> getNouns(){
        return nouns;
    }

}