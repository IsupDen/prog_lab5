package util;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Person;

import java.io.IOException;
import java.time.LocalDateTime;

import static util.Console.println;
import static util.TextFormat.errText;

public class LabFactory implements LabFactoryInterface, ObjectValidator{

    private int id = 0;
    private final FieldsReceiverInterface fieldsReceiver;
    private final CollectionManagerInterface collectionManager;

    public LabFactory(FieldsReceiver fieldsReceiver, CollectionManager collectionManager) {
        this.fieldsReceiver = fieldsReceiver;
        this.collectionManager = collectionManager;
    }

    @Override
    public LabWork createLabWork() {
        id++;
        while (!collectionManager.getIdList().add(id)) {
            id++;
        }
        try {
            collectionManager.getIdList().remove(id);
            String name = fieldsReceiver.getName();
            Coordinates coordinates = fieldsReceiver.getCoordinates();
            Double minimalPoint = fieldsReceiver.getMinimalPoint();
            Integer personalQualitiesMinimum = fieldsReceiver.getPersonalQualitiesMinimum();
            Difficulty difficulty = fieldsReceiver.getDifficulty();;
            Person author = fieldsReceiver.getAuthor();
            LabWork labWork = new LabWork(id, name, coordinates, LocalDateTime.now(), minimalPoint,personalQualitiesMinimum, difficulty, author);
            if (!validateObject(labWork)) return null;
            return labWork;
        } catch (IOException e) {
            println(errText("Input or Output error!"));
            return null;
        }

    }
}
