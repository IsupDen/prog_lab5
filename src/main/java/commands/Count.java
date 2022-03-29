package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import static util.FieldsValidatorInterface.*;
import static util.TextFormat.helpText;
import static util.TextFormat.successText;

import java.util.ArrayList;

public class Count extends Command{
    private final CollectionManagerInterface collectionManager;

    public Count(CollectionManager collectionManager) {
        super("count_less_than_pqm", "print the number of elements whose "
                + "personalQualitiesMinimum field value is less than the specified one.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        ArrayList<LabWork> collection = collectionManager.getCollection();

        if (collection.size() == 0) return helpText("\nCollection is empty!\n");

        if (isPositiveInt(arg)) {
            int i = 0;
            for (LabWork labWork : collection) {
                if (labWork.getPersonalQualitiesMinimum() == null ||
                        labWork.getPersonalQualitiesMinimum() < Integer.parseInt(arg)) i++;
            }
            return successText("Amount of elements: " + i + "\n");
        }
        else if (arg.equals("")) {
            return successText("Amount of elements: 0\n");
        }
        return helpText("Personal qualities minimum should be positive integer number\n");
    }
}
