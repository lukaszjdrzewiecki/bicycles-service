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


    /*
     TODO - rower nie moze miec np.: 2 KORB. Zabezpiecz sie przed dodawaniem dóch korb do roweru.
     */
    public void addBicyclePart(String bicycleName, BicyclePartCategory partCategory, String partName) {
        Bicycle bicycle = findBicycle(bicycleName);
        if(bicycle != null) {
            BicyclePart newBicyclePart = new BicyclePart(partCategory, partName);
            bicycle.getParts().add(newBicyclePart);
        }
    }

    public void saveBicycles(String filename) {
        //TODO - zaimplementuj
    }

    public void loadBicycles(String filename) {
        //TODO - zaimplementuj
    }


    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
            System.out.println("-------");
            }
        }
    }
