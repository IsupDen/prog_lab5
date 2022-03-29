package util;

import java.io.BufferedReader;
import java.io.IOException;

public interface ConsoleInterface {
    String readline() throws IOException;

    void setScriptMode(BufferedReader scriptReader);

    void setInteractiveMode();

    boolean getScriptStatus();

    String read();
}
