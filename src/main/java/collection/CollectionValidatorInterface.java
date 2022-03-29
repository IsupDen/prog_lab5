package collection;

import data.LabWork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface CollectionValidatorInterface {
    String validateCollection(List<LabWork> inputCollection, boolean hasLineErr);
}
