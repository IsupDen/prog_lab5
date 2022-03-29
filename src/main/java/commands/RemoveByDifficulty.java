package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.LabWork;
import exceptions.WrongArgException;

import static util.FieldsValidatorInterface.*;
import static util.TextFormat.successText;

import java.util.ArrayList;

public class RemoveByDifficulty extends Command{
    private final CollectionManagerInterface collectionManager;

    public RemoveByDifficulty(CollectionManager collectionManager) {
        super("remove_all_by_difficulty", "remove all elements from the collection by difficulty.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!getDifficultyCorrectStatus(arg)) throw new WrongArgException();
        ArrayList<LabWork> labWorks = collectionManager.getCollection();
        if (arg.equals("null")) labWorks.removeIf(labWork -> labWork.getDifficulty() == null);
        else labWorks.removeIf(labWork -> labWork.getDifficulty() != null &&
                labWork.getDifficulty().toString().equals(arg.toUpperCase()));
        return successText("Objects has been removed!\n");
    }
}
