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



        for (Bicycle x : bicycles) {
            if(x.getName().equals(bicycleName)) {
                BicyclePart newBicyclePart = new BicyclePart();
                newBicyclePart.setCategory(partCategory);
                newBicyclePart.setName(partName);

                x.parts.add(newBicyclePart);

            } else {
                continue;
            }
        }

      //  bicycles.add(newBicyclePart);
    }


    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle.name);
           // System.out.println(bicycle.parts.toString());
            for (BicyclePart part : bicycle.parts ){
                System.out.println(part.getCategory()+" --- "+part.getName());

            }
            System.out.println("-------");
            }
        }
    }
