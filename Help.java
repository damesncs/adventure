public class Help extends Command {
    
    public Help(){
        super();
    }

    public String run(GameState state){
        String help = "";
        help += formatHelp(Command.INV, ListInventory.getHelp());
        help += formatHelp(Command.LOOK, Look.getHelp());
        help += formatHelp(Command.GO, Go.getHelp());
        help += formatHelp(Command.HELP, Help.getHelp());
        return help;
    }

    private String formatHelp(String cmd, String help){
        return cmd + " " + help + "\n";
    }

    public static String getHelp(){
        return "displays this message";
    }
}
