package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;
import util.LabFactory;
import util.LabFactoryInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static util.TextFormat.helpText;

public class Show extends Command{
    private final CollectionManagerInterface collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show", "print all elements in string representation to standard output.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        if (collectionManager.getCollection().size() == 0)
            return helpText("Collection is empty!\n");
        StringBuilder sb = new StringBuilder();
        ArrayList<LabWork> labWorks = collectionManager.getCollection();
        Collections.sort(labWorks);
        for (LabWork labWork : labWorks) {
            sb.append(labWork);
            sb.append("------------\n");
        }
        return sb.toString();
    }
}
