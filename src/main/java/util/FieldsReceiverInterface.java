package util;

import data.Coordinates;
import data.Difficulty;
import data.Person;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import static util.Console.print;
import static util.Console.println;
import static util.TextFormat.errText;
import static util.TextFormat.helpText;

public interface FieldsReceiverInterface {

    default String getFirstRequest(String requestField, ConsoleInterface console) {
        println();
        println(StringUtils.repeat("-", requestField.length()));
        println(requestField.toUpperCase());
        println(StringUtils.repeat("-", requestField.length()));
        print("Enter " + requestField + ": ");
        return console.read();
    }

    default String getNextRequest(String requestField, String options, ConsoleInterface console) {
        println(helpText(requestField + " should be " + options + "!"));
        print("Enter " + requestField + " again: ");
        return console.read();
    }

    default String getFirstEnumRequest(String requestField, String enumerateList, ConsoleInterface console) {
        println();
        println(StringUtils.repeat("-", requestField.length()));
        println(requestField.toUpperCase());
        println(StringUtils.repeat("-", requestField.length()));
        println("Available " + requestField + ": " + enumerateList);
        print("Enter " + requestField + ": ");
        return console.read();
    }

    default String getUniversalEnumRequest(String requestField, ConsoleInterface console) {
        println(errText("It's incorrect " + requestField + "!") );
        print("Enter " + requestField + " again: ");
        return console.read();
    }

    String getName() throws IOException;
    Coordinates getCoordinates() throws IOException;
    Double getMinimalPoint() throws IOException;
    Integer getPersonalQualitiesMinimum() throws IOException;
    Difficulty getDifficulty() throws IOException;
    Person getAuthor() throws IOException;
}
