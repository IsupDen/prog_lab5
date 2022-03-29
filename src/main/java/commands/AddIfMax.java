package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;
import util.LabFactory;
import util.LabFactoryInterface;

import static util.TextFormat.*;

public class AddIfMax extends Command{

    private final CollectionManagerInterface collectionManager;
    private final LabFactoryInterface labFactory;

    public AddIfMax(LabFactory labFactory, CollectionManager collectionManager) {
        super("add_if_max", "add new element to the collection, if it`s greater, than biggest element of this collection.");
        this.collectionManager = collectionManager;
        this.labFactory = labFactory;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        LabWork inputLabWork = labFactory.createLabWork();

        if (inputLabWork != null) {
            LabWork maxLabwork = collectionManager.getMax();
            if (maxLabwork != null) {
                if (inputLabWork.compareTo(maxLabwork) <= 0)
                    return helpText("Labwork isn't best!\n");
            }
            collectionManager.add(inputLabWork);
            return successText("Labwork has been added!\n");
        } else {
            return errText("Object hasn't been added!(fields were entered incorrectly)\n");
        }
    }
}
