package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import static util.FieldsValidatorInterface.*;
import static util.TextFormat.errText;
import static util.TextFormat.successText;

import exceptions.WrongArgException;
import util.LabFactory;
import util.LabFactoryInterface;

public class Update extends Command{
    private final CollectionManagerInterface collectionManager;
    private final LabFactoryInterface labFactory;

    public Update(LabFactory labFactory, CollectionManager collectionManager) {
        super("update", "update the element`s value, whose ID is equal to the given. ");
        this.collectionManager = collectionManager;
        this.labFactory = labFactory;
    }

    @Override
    public String execute(String arg) {
        if (!isPositiveInt(arg)) throw new WrongArgException();
        LabWork labWork = collectionManager.getLabworkById(Integer.parseInt(arg));

        if (labWork != null) collectionManager.remove(labWork);
        else return errText("An object with this id does not exist!\n");

        LabWork upgradingGroup = labFactory.createLabWork();
        upgradingGroup.setId(Integer.parseInt(arg));
        collectionManager.add(upgradingGroup);
        System.out.println(collectionManager.getIdList().toString());

        return successText("Object has been updated!\n");
    }
}
