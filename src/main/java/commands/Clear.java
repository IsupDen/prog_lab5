package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import exceptions.WrongArgException;

import static util.TextFormat.successText;

public class Clear extends Command{
    private final CollectionManagerInterface collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", "clear the collection.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        collectionManager.clear();
        return successText("Successful!\n");
    }
}
