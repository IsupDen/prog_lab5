package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Console.print;
import static util.Console.println;
import static util.TextFormat.errText;

public class CommandReader implements CommandReaderInterface{

    private final ConsoleInterface console;
    private final InvokerInterface invoker;

    public CommandReader(InvokerInterface invoker) {
        console = invoker.getConsole();
        this.invoker = invoker;
    }

    @Override
    public void enable() {
        String nextLine;
        while (true) {
            print("Enter the command: ");
            nextLine = console.read();
            CorrectCommand newCommand = readCommand(nextLine);
            if (newCommand == null) {
                println(errText("Command entered incorrectly!"));
            } else invoker.execute(newCommand);
        }

    }

    @Override
    public CorrectCommand readCommand(String string) {
        String command;
        String arg;
        Pattern commandName = Pattern.compile("^\\w+");
        try {
            Matcher matcher = commandName.matcher(string);
            if (matcher.find()) {
                command = matcher.group();
            } else {
                return null;
            }
            arg = string.substring(command.length());
            return new CorrectCommand(command.trim().toLowerCase(), arg.trim());
        } catch (NullPointerException e) {
            return null;
        }
    }
}
