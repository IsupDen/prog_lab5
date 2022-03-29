package file;

import java.io.File;
import java.io.IOException;

public interface FileWorkerInterface {
    String saveToCSV();
    String getFromCSV();
    void setPath(String path);
    void create(File file) throws IOException;
    boolean changeReadPermissions(File file);
    void changeWritePermissions(File file);
}
