package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class Bicycle {

    private String name;
    private List<BicyclePart> parts = new ArrayList();


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public List<BicyclePart> getParts() {
        return parts;
    }
    public void setParts(List<BicyclePart> parts) { this.parts = parts; }

    public String toString(){return "Bicycle name: " + name + "\n" + parts;}

}
