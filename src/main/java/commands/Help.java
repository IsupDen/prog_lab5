package commands;

import exceptions.WrongArgException;

import java.util.Map;
import java.util.Queue;

import static util.TextFormat.helpText;

/**
 * @command "display help for available commands."
 */

public class Help extends Command{

    private final Map<String, Command> commandsInfo;

    public Help(Map<String, Command> commands) {
        super("help" , "display help for available commands.");
        commandsInfo = commands;
    }


    @Override
    public String execute(String arg) {
        if (arg.equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append(helpText("For information about a specific command, type HELP <command name>\n"));
            sb.append("\nList of commands:\n");
            for (String i : commandsInfo.keySet()) {
                sb.append(commandsInfo.get(i).getDescription()).append("\n");
            }
            return sb.toString();
        } else {
            return commandsInfo.get(arg).toString();
        }
    }
}
