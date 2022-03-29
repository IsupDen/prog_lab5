package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import data.Coordinates;
import data.LabWork;
import exceptions.WrongArgException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static util.TextFormat.helpText;

public class Group extends Command{
    private final CollectionManagerInterface collectionManager;

    public Group(CollectionManager collectionManager) {
        super("group_counting_by_coordinates", "group the elements of the collection by" +
                "the value of the coordinates field, display the number of elements in each group.");
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        HashMap<String, AtomicInteger> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (LabWork labWork: collectionManager.getCollection()){
            Coordinates coordinates = labWork.getCoordinates();
            if (map.containsKey(coordinates.toString())){
                map.get(coordinates.toString()).incrementAndGet();
            } else{
                map.put(coordinates.toString(), new AtomicInteger(1));
            }
            }

        if (map.size()==0) return helpText("Collection is empty!\n");
        else{
            for (Map.Entry<String, AtomicInteger> pair : map.entrySet()) {
                String coordinates = pair.getKey();
                int quantity = pair.getValue().intValue();
                sb.append(coordinates).append(" : ").append(quantity).append("\n");
            }
            return sb.toString();
        }
    }
}
