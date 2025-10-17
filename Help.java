public class Help extends Command {
    
    public Help(){
        super();
    }

    public String run(GameState state){
        String help = "";
        help += formatHelp(Command.INV, ListInventory.getHelp());
        help += formatHelp(Command.LOOK, Look.getNounHelp(), Look.getHelp());
        help += formatHelp(Command.GO, Go.getNounHelp(), Go.getHelp());
        help += formatHelp(Command.HELP, Help.getHelp());
        return help;
    }

    private String formatHelp(String cmd, String nounHelp, String help){
        if(nounHelp.length() > 0) return cmd + " [" + nounHelp + "] - " + help + "\n";
        return cmd + " - " + help + "\n";
    }

    private String formatHelp(String cmd, String help){
        return formatHelp(cmd, "", help);
    }

    public static String getHelp(){
        return "displays this message";
    }
}
