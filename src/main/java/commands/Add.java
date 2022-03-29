package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;
import util.LabFactory;
import util.LabFactoryInterface;

import static util.TextFormat.errText;
import static util.TextFormat.successText;

public class Add extends Command{

    private final CollectionManagerInterface collectionManager;
    public final LabFactoryInterface labFactory;

    public Add(CollectionManager collectionManager, LabFactory labFactory) {
        super("add", "add new element to the collection.");
        this.collectionManager = collectionManager;
        this.labFactory = labFactory;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        LabWork labWork = labFactory.createLabWork();

        if (labWork != null) {
            collectionManager.add(labWork);
            return successText("Labwork has been added!\n");
        } else {
            return errText("Object hasn't been added!(fields were entered incorrectly)\n");
        }
    }
}
