package util;

public interface InvokerInterface {
    void execute(CorrectCommand correctCommand);
    boolean addScriptPath(String arg);
    void removeScriptPath(String arg);
    Console getConsole();
}
