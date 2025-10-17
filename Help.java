public class Help extends Command {
    
    public Help(){
        super();
    }

    public String run(GameState state){
        String help = "";
        help += formatHelp(Adventure.INV, ListInventory.getHelp());
        help += formatHelp(Adventure.LOOK, Look.getHelp());
        help += formatHelp(Adventure.GO, Go.getHelp());
        help += formatHelp(Adventure.HELP, Help.getHelp());
        return help;
    }

    private String formatHelp(String cmd, String help){
        return cmd + " - " + help + "\n";
    }

    public static String getHelp(){
        return "displays this message";
    }
}
