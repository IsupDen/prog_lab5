package util;

public interface CommandReaderInterface {
    void enable();
    CorrectCommand readCommand(String string);
}
