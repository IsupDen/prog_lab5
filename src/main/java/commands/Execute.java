package commands;

import util.*;

import java.io.*;

import static util.TextFormat.errText;
import static util.TextFormat.successText;

public class Execute extends Command{
    private final InvokerInterface invoker;

    public Execute(Invoker invoker) {
        super("execute_script", "Read and execute script from entered file.");
        this.invoker = invoker;
    }

    @Override
    public String execute(String arg) {
        if (arg.equals("")) return errText("You should write script path!\n");
        else {
            File file = new File(arg);
            if (file.exists() && !file.canRead())
                return errText("This command cannot be executed because the specified file does not have read permissions!\n");

            if (!(invoker.addScriptPath(arg))) return errText("Recursion has been found in " +
                    "command: execute_script " + arg + "!" +
                    " Please correct your script!\n");
            else {
                invoker.addScriptPath(arg);

                try {
                    BufferedReader scriptBufferedReader = new BufferedReader(new FileReader(arg));
                    ScriptReader scriptReader = new ScriptReader(scriptBufferedReader, invoker);
                    scriptReader.read();
                    scriptBufferedReader.close();
                } catch (FileNotFoundException e) {
                    invoker.removeScriptPath(arg);
                    return errText("File not found!\n");
                } catch (IOException e) {
                    invoker.removeScriptPath(arg);
                    return errText("Input or Output error!\n");
                }
                invoker.removeScriptPath(arg);
                invoker.getConsole().setInteractiveMode();
                return successText("The script " + arg + " was processed successfully!\n");
            }
        }
    }
}
