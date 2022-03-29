package util;

import java.io.BufferedReader;
import java.io.IOException;
import static util.Console.println;
import static util.TextFormat.errText;

public class ScriptReader {

    private final BufferedReader scriptBufferReader;
    private final InvokerInterface invoker;
    private final CommandReaderInterface commandReader;
    private final Console console;

    public ScriptReader(BufferedReader scriptBufferReader, InvokerInterface invoker) {
        this.scriptBufferReader = scriptBufferReader;
        this.invoker = invoker;
        commandReader = new CommandReader(invoker);
        console = invoker.getConsole();
    }

    public void read() {
        String nextLine;
        CorrectCommand nextCommand;
        console.setScriptMode(scriptBufferReader);
        do {
            nextCommand = null;
            try {
                nextLine = scriptBufferReader.readLine();
                if (nextLine != null) nextCommand = commandReader.readCommand(nextLine + " ");
            } catch (IOException e) {
                println(errText("Input or Output error!"));
                break;
            }
            if (nextCommand != null) {
                invoker.execute(nextCommand);
            } else  if (nextLine != null) println(errText("Command entered incorrectly!"));

        } while (nextLine != null);
    }
}
