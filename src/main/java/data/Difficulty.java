package data;

import java.util.Arrays;
import java.util.List;

public enum Difficulty {
    NORMAL("NORMAL"),
    INSANE("INSANE"),
    TERRIBLE("TERRIBLE"),
    NULL("NULL");

    private final String stringValue;

    Difficulty(String stringValue) {
        this.stringValue = stringValue;
    }

    private String getStringValue() {
        return stringValue;
    }

    public static boolean isIncludeElement(String difficulty) {
        for (Difficulty currentDifficulty : Difficulty.values()) {
            if (difficulty.equals("NULL")) return false;
            if (difficulty.equals(currentDifficulty.getStringValue())) return true;
        }
        return false;
    }

    public static List<Difficulty> getAvailableValues() {
        List<Difficulty> values = Arrays.asList(Difficulty.values());
        return values.subList(0, values.size() -1);
    }
}
