**Описание хранимых в коллекции классов:**

```java
public class LabWork {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double minimalPoint; //Поле не может быть null, Значение поля должно быть больше 0
    private Integer personalQualitiesMinimum; //Поле может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле не может быть null
}
public class Coordinates {
    private Integer x; //Поле не может быть null
    private int y;
}
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Double height; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
}
public enum Difficulty {
    NORMAL,
    INSANE,
    TERRIBLE
}
public enum Color {
    BLACK,
    BLUE,
    ORANGE,
    WHITE,
    BROWN
}
public enum Color {
    GREEN,
    BLUE,
    ORANGE,
    WHITE,
    BROWN
}
public enum Country {
    GERMANY,
    VATICAN,
    ITALY,
    NORTH_KOREA
}
```