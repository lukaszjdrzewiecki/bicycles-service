package p76.bicycles.dto;

public class Tyre {
    private String name;
    private int width;
    private boolean tubeless;

    public Tyre() {
    }

    public Tyre(String name, int width, boolean tubeless) {
        this.name = name;
        this.width = width;
        this.tubeless = tubeless;
    }
}
