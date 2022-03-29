package commands;

import exceptions.WrongArgException;

import static util.Console.println;
import static util.TextFormat.errText;
import static util.TextFormat.successText;

public class Exit extends Command{

    public Exit() {
        super("exit", "end the program (without saving it to a file).");
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        println(successText("Thank you for working in this program!"));
        System.exit(0);
        return null;
    }
}
