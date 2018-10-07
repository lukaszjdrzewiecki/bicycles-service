package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class Bicycle {
    public String name;
    public List<BicyclePart> parts = new ArrayList();

    public String getName() {
        return name;
    }


    public void setName(String name) { this.name = name; }

    public List<BicyclePart> getParts() {
        return parts;
    }

    public void setParts(List<BicyclePart> parts) {
        this.parts = parts;
    }
}
