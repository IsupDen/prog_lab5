package util;

import collection.CollectionManager;
import commands.*;
import exceptions.WrongArgException;
import file.FileWorker;

import java.util.*;

import static util.Console.println;
import static util.TextFormat.errText;

public class Invoker implements InvokerInterface{

    private final Console console;
    private final CollectionManager collectionManager;
    private final Map<String, Command> commands;
    private final LabFactory labFactory;
    private final Set<String> executedScripts;
    private final FileWorker fileWorker;

    public Invoker(Console console, CollectionManager collectionManager, FileWorker fileWorker) {
        this.console = console;
        FieldsReceiver fieldsReceiver = new FieldsReceiver(console);
        this.collectionManager = collectionManager;
        this.labFactory = new LabFactory(fieldsReceiver, collectionManager);
        commands = new HashMap<>();
        executedScripts = new HashSet<>();
        this.fileWorker = fileWorker;
        initMap();
    }

    @Override
    public void execute(CorrectCommand correctCommand) {
        String command = correctCommand.getCommandName();
        String arg = correctCommand.getArgName();

        if (commands.containsKey(command)) {
            try {
                println(commands.get(command).execute(arg));
            } catch (WrongArgException e) {
                println(e.getMessage());
            }
        } else {
            println(errText("Command not found. Please, try again!"));
        }
    }

    @Override
    public boolean addScriptPath(String arg) {
        return executedScripts.add(arg);
    }

    @Override
    public void removeScriptPath(String arg) {
        executedScripts.remove(arg);
    }

    @Override
    public Console getConsole() {
        return console;
    }

    private void initMap() {
        commands.put("help", new Help(commands));
        commands.put("add", new Add(collectionManager, labFactory));
        commands.put("add_if_max", new AddIfMax(labFactory, collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("count_less_than_pqm", new Count(collectionManager));
        commands.put("execute_script", new Execute(this));
        commands.put("group_counting_by_coordinates", new Group(collectionManager));
        commands.put("info", new Info(collectionManager));
        commands.put("remove_by_id", new Remove(collectionManager));
        commands.put("remove_all_by_difficulty", new RemoveByDifficulty(collectionManager));
        commands.put("remove_first", new RemoveFirst(collectionManager));
        commands.put("reorder", new Reorder(collectionManager));
        commands.put("save", new Save(fileWorker));
        commands.put("show", new Show(collectionManager));
        commands.put("update", new Update(labFactory, collectionManager));
        commands.put("exit", new Exit());
    }
}
