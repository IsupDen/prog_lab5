package collection;

import data.LabWork;
import util.ObjectValidator;

import java.util.List;

import static util.TextFormat.errText;
import static util.TextFormat.successText;

public class CollectionValidator implements CollectionValidatorInterface, ObjectValidator {

    CollectionManagerInterface collectionManger;

    public CollectionValidator(CollectionManager collectionManager) {
        this.collectionManger = collectionManager;
    }

    @Override
    public String validateCollection(List<LabWork> inputCollection, boolean hasLineErr) {
        boolean hasErr = hasLineErr;
        for (LabWork labWork : inputCollection) {
            if (validateObject(labWork)) collectionManger.add(labWork);
            else hasErr = true;
        }
        if (hasErr) return errText("CSV file has been broken!(not all objects was loaded)");
        return successText("Collection was loaded!");
    }
}
