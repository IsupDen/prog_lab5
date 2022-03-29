package commands;

import java.io.IOException;

public interface CommandInterface {
    String getDescription();
    Object execute(String arg) throws IOException;
}
