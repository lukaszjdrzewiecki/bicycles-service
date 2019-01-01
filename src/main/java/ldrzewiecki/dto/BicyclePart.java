package ldrzewiecki.dto;

public abstract class BicyclePart {

    private String name;

    public BicyclePart(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){return name;}

}
