package util;

public class CorrectCommand {

    private final String commandName;
    private final String argName;

    public CorrectCommand(String commandName, String argName) {
        this.commandName = commandName;
        this.argName = argName;
    }

    public  String getCommandName() {
        return commandName;
    }
    public String getArgName() {
        return argName;
    }
}
