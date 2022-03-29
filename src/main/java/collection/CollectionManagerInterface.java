package collection;

import data.LabWork;
import java.util.ArrayList;
import java.util.HashSet;

public interface CollectionManagerInterface {

    ArrayList<LabWork> getCollection();
    HashSet<Integer> getIdList();
    String getInfo();
    void setCollection(ArrayList<LabWork> labWorks);
    void add(LabWork labWork);
    void remove(LabWork labWork);
    LabWork getLabworkById(int id);
    void clear();
    LabWork getMax();
}
