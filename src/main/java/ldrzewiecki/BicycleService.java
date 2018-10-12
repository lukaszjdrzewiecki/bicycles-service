package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();

    public Bicycle findBicycle(String name) {
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getName().equals(name)){
                return bicycle;
            }
        }
        return null;
    }


    public void addBicycle(String name) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);


       Bicycle bicycle = findBicycle(name);
       if(bicycle != null) {
           throw new RuntimeException("You");
       }

        bicycles.add(newBicycle);
    }




    public void addBicyclePart(String bicycleName, String partCategory, String partName) {

        Bicycle bicycle = findBicycle(bicycleName);
        if(bicycle != null) {
            BicyclePart newBicyclePart = new BicyclePart();
            newBicyclePart.setCategory(partCategory);
            newBicyclePart.setName(partName);

            bicycle.getParts().add(newBicyclePart);
        }
    }

    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
            for (BicyclePart part : bicycle.getParts() ){
                System.out.println(part);
            }
            System.out.println("-------");
            }
        }
    }
