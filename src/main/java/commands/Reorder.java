package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;

import java.util.ArrayList;
import java.util.Collections;

import static util.TextFormat.successText;

public class Reorder extends Command{
    private final CollectionManagerInterface collectionManager;

    public Reorder(CollectionManager collectionManager) {
        super("reorder", "sort the collection in reverse order.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        ArrayList<LabWork> labWorks = collectionManager.getCollection();
        Collections.reverse(labWorks);
        collectionManager.setCollection(labWorks);
        return successText("collection successfully sorted!\n");
    }
}
