package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;

import static util.FieldsValidatorInterface.*;
import static util.TextFormat.errText;
import static util.TextFormat.successText;

public class Remove extends Command{
    private final CollectionManagerInterface collectionManager;

    public Remove(CollectionManager collectionManager) {
        super("remove_by_id", "remove an element from the collection by ID.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!isPositiveInt(arg)) throw new WrongArgException();
        LabWork labWork = collectionManager.getLabworkById(Integer.parseInt(arg));

        if (labWork != null) collectionManager.remove(labWork);
        else return errText("An object with this id does not exist!\n");

        return successText("Object has been removed!\n");

    }
}
