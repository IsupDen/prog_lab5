import collection.CollectionManager;
import file.FileWorker;
import util.CommandReader;
import util.Console;
import util.Invoker;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static util.Console.print;
import static util.Console.println;
import static util.TextFormat.*;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        print("\033[H\033[J");
        println(successText("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557\n\u2551 \u2593     \u2593\u2593\u2593\u2593\u2593 \u2593\u2593\u2593\u2593    \u2593   \u2593 \u2593\u2593\u2593\u2593\u2593 \u2593\u2593\u2593\u2593  \u2593  \u2593 \u2551\n\u2551 \u2593     \u2593   \u2593 \u2593   \u2593   \u2593 \u2593 \u2593 \u2593   \u2593 \u2593   \u2593 \u2593 \u2593  \u2551\n\u2551 \u2593     \u2593\u2593\u2593\u2593\u2593 \u2593\u2593\u2593\u2593    \u2593 \u2593 \u2593 \u2593   \u2593 \u2593\u2593\u2593\u2593  \u2593\u2593   \u2551\n\u2551 \u2593     \u2593   \u2593 \u2593   \u2593   \u2593 \u2593 \u2593 \u2593   \u2593 \u2593 \u2593   \u2593 \u2593  \u2551\n\u2551 \u2593\u2593\u2593\u2593\u2593 \u2593   \u2593 \u2593\u2593\u2593\u2593     \u2593 \u2593  \u2593\u2593\u2593\u2593\u2593 \u2593  \u2593  \u2593  \u2593 \u2551\n\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563\n\u2551     \u250c\u2500\u256e\u250c\u2500\u250c\u2500\u256e\u252c\u256d\u2500\u2574    \u252c\u256d\u2500\u2574\u2577 \u2577\u250c\u2500\u256e\u256d\u2500\u256e\\    \u002f    \u2551\n\u2551     \u2502 \u2502\u251c\u2500\u2502 \u2502\u2502\u2570\u2500\u256e    \u2502\u2570\u2500\u256e\u2502 \u2502\u251c\u2500\u256f\u2502 \u2502 \\  \u002f     \u2551\n\u2551     \u2514\u2500\u256f\u2514\u2500\u2575 \u2575\u2534\u2576\u2500\u256f    \u2534\u2576\u2500\u256f\u2570\u2500\u256f\u2575  \u2570\u2500\u256f  \\\u002f      \u2551\n\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d"));
        println("\n\n");
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        CollectionManager collectionManager = new CollectionManager();
        FileWorker fileWorker = new FileWorker(collectionManager, console);
        if (args.length != 0) {
            fileWorker.setPath(args[0]);
            println(fileWorker.getFromCSV());
        }
        else println(errText("No file passed by argument! Collection is empty!"));
        Invoker invoker = new Invoker(console, collectionManager, fileWorker);
        CommandReader commandReader = new CommandReader(invoker);
        commandReader.enable();
        scanner.close();
    }
}
