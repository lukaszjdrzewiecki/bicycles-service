package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();


    public void addBicycle(String name) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);

        for (Bicycle bicycle : bicycles) {
            if(bicycle.getName().equals(name)) {
                System.out.println("Nie mozna dodac dwoch rowerow o tej samej nazwie");
                return;
            }
        }

        bicycles.add(newBicycle);
    }

    public void addBicyclePart(String bicycleName, String partCategory, String partName) {
        Bicycle newBicyclePart = new Bicycle();

        for (Bicycle bicycle : bicycles) {
            if(bicycle.getName().equals(bicycleName)) {
                newBicyclePart.setName(partCategory);
                newBicyclePart.setName(partName);
            } else {
                return;
            }
        }



        bicycles.add(newBicyclePart);
    }

    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycles);
            }
        }
    }
}
