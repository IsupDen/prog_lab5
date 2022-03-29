package file;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import collection.CollectionValidator;
import collection.CollectionValidatorInterface;
import data.LabWork;
import util.Console;
import util.ConsoleInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static util.Console.print;
import static util.Console.println;
import static util.TextFormat.*;

public class FileWorker implements FileWorkerInterface{
    private final CollectionManagerInterface collectionManger;
    private final CollectionValidatorInterface collectionValidator;
    private final ConsoleInterface console;
    private String path;

    public FileWorker(CollectionManager collectionManager, Console console) {
        this.collectionManger = collectionManager;
        this.collectionValidator = new CollectionValidator(collectionManager);
        this.console = console;
    }

    @Override
    public String saveToCSV() {

        try {
            File outFile = new File(path);
            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ArrayList<LabWork> labWorks= collectionManger.getCollection();
            Collections.sort(labWorks);
            for (LabWork labWork : labWorks) {
                String str = labWork.toCsv();
                bufferedWriter.write(str + "\n");
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            return errText("Output error!");
        }
        return successText("Collection recorded successfully!\n");
    }

    @Override
    public String getFromCSV(){

        try {
            File file = new File(path);
            if (!file.exists()) create(file);
            else {
                boolean hasLineErr = false;
                if (!file.canWrite()) changeWritePermissions(file);
                if (!file.canRead()) {
                    if (!changeReadPermissions(file)) return helpText("Collection is empty!");
                }
                FileInputStream fileStream = new FileInputStream(file);
                InputStreamReader reader = new InputStreamReader(fileStream);

                char[] buffer = new char[fileStream.available()];
                reader.read(buffer, 0, fileStream.available());
                String[] labs = new String(buffer).split("\n");
                List<data.LabWork> labWorks = new ArrayList<>();
                for (String lab : labs) {
                    try {
                        labWorks.add(new LabWork(lab.split(",")));
                    } catch (IllegalArgumentException e) {
                        hasLineErr = true;
                    }

                }
                return collectionValidator.validateCollection(labWorks, hasLineErr);
            }
            return "Cannot access file! Collection is empty";
        }
        catch (IOException e) {
            return errText("Cannot access file! Collection is empty");
        }
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void create(File file) throws IOException{
        if (file.createNewFile()) {
            println(successText("New file created successfully!"));
        }
        else {
            println(errText("Failed to create file!"));
        }
    }

    @Override
    public boolean changeReadPermissions(File file) {
        print(errText("Cannot read file!\n") + helpText("Try to change permissions? [Y/N] "));
        String input;
        do {
            try {
                input = console.read();
                if (input.equals("Y") || input.equals("Yes")) {
                    if (!file.setReadable(true)) {
                        println(errText("Failed to change permissions"));
                        return false;
                    } else {
                        println(successText("Permissions changed successfully!"));
                        return true;
                    }
                } else if (input.equals("N") || input.equals("No")) return false;
                else print(errText("Please, write 'Yes' or 'No' [Y/N]: "));
            } catch (NullPointerException e) {
                print(errText("Please, write 'Yes' or 'No' [Y/N]: "));
            }
        } while (true);
    }

    @Override
    public void changeWritePermissions(File file) {
        print(errText("Cannot write file! You can't save data if you will to want!\n") +
                helpText("Try to change permissions? [Y/N] "));
        String input;
        do {
            try {
                input = console.read();
                if (input.equals("Y") || input.equals("Yes")) {
                    if (!file.setWritable(true)) {
                        println(errText("Failed to change permissions!"));
                    } else println(successText("Permissions changed successfully!"));
                } else if (!input.equals("N") && !input.equals("No"))
                    print(errText("Please, write 'Yes' or 'No [Y/N] "));
            } catch (NullPointerException e) {
                input = "";
                print(errText("Please, write 'Yes' or 'No' [Y/N]: "));
            }
        } while (!input.equals("Y") && !input.equals("N") && !input.equals("Yes") && !input.equals("No"));
    }
}
