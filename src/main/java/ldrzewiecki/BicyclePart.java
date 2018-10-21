package ldrzewiecki;

public class BicyclePart {


    private BicyclePartCategory category;
    private String name;


    public BicyclePart(BicyclePartCategory category, String name){this.category = category; this.name = name;}


    public BicyclePartCategory getCategory() {
        return category;
    }

    public void setCategory(BicyclePartCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){return "part: " + category + " " + name;}

}
