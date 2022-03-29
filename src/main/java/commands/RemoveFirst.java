package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;
import util.LabFactory;
import util.LabFactoryInterface;

import java.util.ArrayList;

import static util.TextFormat.successText;

public class RemoveFirst extends Command{
    private final CollectionManagerInterface collectionManager;

    public RemoveFirst(CollectionManager collectionManager) {
        super("remove_first", "remove the first element from the collection.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        collectionManager.remove(collectionManager.getCollection().get(0));
        return successText("First element successfully deleted\n");
    }
}
