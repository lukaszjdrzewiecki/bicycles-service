package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Bicycle {

    private String name;
    private Map<BicyclePartCategory, BicyclePart> parts = new HashMap();


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public Map<BicyclePartCategory, BicyclePart> getParts() {
        return parts;
    }
    public void setParts(Map<BicyclePartCategory, BicyclePart> parts) { this.parts = parts; }

    public String toString(){return "Bicycle name: " + name + " Parts: " + parts;}

    //public int getNoOfParts() { return parts.size(); }


}
