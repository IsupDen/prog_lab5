package commands;

import collection.CollectionManager;
import collection.CollectionManagerInterface;
import exceptions.WrongArgException;
import file.FileWorker;
import file.FileWorkerInterface;
import util.LabFactory;
import util.LabFactoryInterface;

public class Save extends Command{
    private final FileWorkerInterface fileWorker;

    public Save(FileWorker fileWorker) {
        super("save", "save the collection to file.");
        this.fileWorker = fileWorker;
    }

    @Override
    public String execute(String arg) {
        if (!arg.equals("")) throw new WrongArgException();
        return fileWorker.saveToCSV();
    }
}
