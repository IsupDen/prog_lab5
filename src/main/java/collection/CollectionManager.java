package collection;

import data.LabWork;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.HashSet;

public class CollectionManager implements CollectionManagerInterface {

    private ArrayList<data.LabWork> labWorks = new ArrayList<>();
    private final LocalDateTime createdDate = LocalDateTime.now();
    private final HashSet<Integer> idList = new HashSet<>();

    @Override
    public ArrayList<LabWork> getCollection() {
        return labWorks;
    }

    @Override
    public HashSet<Integer> getIdList() {
        return idList;
    }

    @Override
    public String getInfo() {
        return  "Collection type      : ArrayList\n" +
                "Collection name      : LabWorks\n" +
                "Initialization date  : " + createdDate + "\n" +
                "Collection size      : " + labWorks.size() + "\n";
    }

    @Override
    public void setCollection(ArrayList<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void add(LabWork labWork) {
        if (idList.contains(labWork.getId())) {
            labWorks.remove(this.getLabworkById(labWork.getId()));
        }
        if (labWorks.add(labWork)) {
            idList.add(labWork.getId());
        }
        else idList.remove(labWork.getId());
    }

    @Override
    public void remove(LabWork labWork) {
        labWorks.remove(labWork);
    }

    @Override
    public LabWork getLabworkById(int id) {
        for (LabWork labWork : labWorks) {
            if (labWork.getId() == id) {
                return labWork;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        labWorks.clear();
    }

    @Override
    public LabWork getMax() {
        if (labWorks.size() == 0) return null;

        LabWork maximalLab = null;

        for (LabWork labWork : labWorks) {
            if (maximalLab == null) {
                maximalLab = labWork;
            } else if (labWork.compareTo(maximalLab) > 0) {
                maximalLab = labWork;
            }
        }
        return maximalLab;
    }
}
