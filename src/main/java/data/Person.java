package data;

public class Person {
    private String name;
    private Double height;
    private EyeColor eyeColor;
    private HairColor hairColor;
    private Country nationality;

    public Person(String name, Double height, HairColor hairColor, EyeColor eyeColor, Country nationality) {
        this.name = name;
        this.height = height;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
    }

    public Person() {
        name = null;
        height = null;
        hairColor = null;
        eyeColor = null;
        nationality = null;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public Country getNationality() {
        return nationality;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    @Override
    public String toString() {
        return "name - " + name + ", " +
                "height - " + height + ", " +
                "hair color - " + hairColor + ", " +
                "eyeColor - " + eyeColor + ", " +
                "nationality - " + nationality;
    }

    public String toCsv() {
        return name + "," + height + "," + eyeColor + "," + hairColor + "," + nationality;
    }
}

