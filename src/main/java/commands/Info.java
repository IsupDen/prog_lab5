package commands;

import collection.CollectionManager;
import exceptions.WrongArgException;

public class Info extends Command{

    private final CollectionManager collectionManager;

    public Info(CollectionManager aCollectionManager) {
        super("info", "Print information about the collection.");
        collectionManager = aCollectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        return "\nInformation about collection:\n\n" + collectionManager.getInfo();
    }
}
