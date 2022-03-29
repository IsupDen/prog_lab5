package util;

import static util.Console.println;
import static util.FieldsValidatorInterface.*;
import data.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static util.Console.print;

public class FieldsReceiver implements FieldsReceiverInterface{


    private final ConsoleInterface console;

    public FieldsReceiver(Console console) {
        this.console = console;
    }

    @Override
    public String getName() throws IOException {
        String line;
        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getNameCorrectStatus(line)) return null;
        } else {
            line = getFirstRequest("labwork name", console);
            while (!getNameCorrectStatus(line)) {
                line = getNextRequest("labwork name", "not empty string", console);
            }
        }
        return line;
    }

    @Override
    public Coordinates getCoordinates() throws IOException {
        String line;
        int x;
        int y;

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getCoordinateCorrectStatus(line)) return null;
            x = Integer.parseInt(line);

            line = console.readline();
            if (!getCoordinateCorrectStatus(line)) return null;

        } else {
            line = getFirstRequest("labwork coordinate x", console);

            while (!getCoordinateCorrectStatus(line)) {
                line = getNextRequest("x coordinate", "not null int number", console);
            }
            x = Integer.parseInt(line);

            line = getFirstRequest("labwork coordinate y", console);

            while (!getCoordinateCorrectStatus(line)) {
                line = getNextRequest("y coordinate", "not null int number", console);
            }
        }
        y = Integer.parseInt(line);

        return new Coordinates(x, y);
    }

    @Override
    public Double getMinimalPoint() throws IOException {
        String line;

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getMinimalPointCorrectStatus(line)) return null;
        } else {
            line = getFirstRequest("labwork minimal point", console);

            while (!getMinimalPointCorrectStatus(line)) {
                line = getNextRequest("labwork minimal point", "positive double number", console);
            }
        }
        return Double.parseDouble(line);
    }

    @Override
    public Integer getPersonalQualitiesMinimum() throws IOException {
        String line;

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getPersonalQualitiesMinimumCorrectStatus(line)) return -1;
        } else {
            line = getFirstRequest("labwork personal qualities minimum", console);

            while (!getPersonalQualitiesMinimumCorrectStatus(line)) {
                line = getNextRequest("labwork personal qualities minimum",
                        "positive Integer number or you can skip this field", console);
            }
        }
        if (line == null || line.equals("null") || line.equals("")) return null;
        return Integer.parseInt(line);
    }

    @Override
    public Difficulty getDifficulty() throws IOException {
        String line;

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getDifficultyCorrectStatus(line)) return Difficulty.valueOf("NULL");

        } else {

            line = getFirstEnumRequest("labwork difficulty", Difficulty.getAvailableValues()
                    + "\n(You can skip this field)", console);

            while (!getDifficultyCorrectStatus(line)) {
                line = getUniversalEnumRequest("labwork difficulty", console);
            }
        }
        if (line == null || line.equals("null") || line.equals("")) return null;
        return Difficulty.valueOf(line.toUpperCase());
    }

    @Override
    public Person getAuthor() throws IOException {
        String line;
        String name;
        double height;
        HairColor hairColor;
        EyeColor eyeColor;
        Country nationality;

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getNameCorrectStatus(line)) return null;

        } else {
            print("\n------\n" +
                    "AUTHOR");
            line = getFirstRequest("labwork author name", console);

            while (!getNameCorrectStatus(line)) {
                line = getNextRequest("labwork author name", "not empty String", console);
            }
        }
        name = line;

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getAuthorHeightCorrectStatus(line)) return null;

        } else {
            line = getFirstRequest("labwork author height", console);

            while (!getAuthorHeightCorrectStatus(line)) {
                line = getNextRequest("labwork author height", "not null positive double number", console);
            }
        }
        height = Double.parseDouble(line);

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getAuthorHairColorCorrectStatus(line)) return null;

        } else {
            line = getFirstEnumRequest("labwork author hair color", Arrays.toString(HairColor.values()), console);

            while (!getAuthorHairColorCorrectStatus(line)) {
                line = getUniversalEnumRequest("lab author hair color", console);
            }
        }
        hairColor = HairColor.valueOf(line.toUpperCase());

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getAuthorEyeColorCorrectStatus(line)) return null;

        } else {
            line = getFirstEnumRequest("labwork author eye color", Arrays.toString(EyeColor.values()), console);

            while (!getAuthorEyeColorCorrectStatus(line)) {
                line = getUniversalEnumRequest("labwork author eye color", console);
            }
        }
        eyeColor = EyeColor.valueOf(line.toUpperCase());

        if (console.getScriptStatus()) {
            line = console.readline();
            if (!getAuthorCountryCorrectStatus(line)) return null;

        } else {
            line = getFirstEnumRequest("labwork author nationality", Arrays.toString(Country.values()), console);

            while (!getAuthorCountryCorrectStatus(line)) {
                line = getUniversalEnumRequest("labwork author nationality", console);
            }
        }
        nationality = Country.valueOf(line.toUpperCase());

        return new Person(name, height, hairColor, eyeColor, nationality);
    }
}
