package ldrzewiecki;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();

    public Bicycle findBicycle(String name) {
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getName().equals(name)) {
                return bicycle;
            }
        }
        return null;
    }


    public void addBicycle(String name) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);
        Bicycle bicycle = findBicycle(name);
        if (bicycle != null) {
            throw new RuntimeException("You");
        }
        bicycles.add(newBicycle);
    }



    /*
     TODO - rower nie moze miec np.: 2 KORB. Zabezpiecz sie przed dodawaniem dóch korb do roweru.
     */
    public void addBicyclePart(String bicycleName, BicyclePartCategory partCategory, String partName) {
        Bicycle bicycle = findBicycle(bicycleName);
        if (bicycle != null) {
            BicyclePart newBicyclePart = new BicyclePart(partCategory, partName);
            bicycle.getParts().put(partCategory, newBicyclePart);
            if (bicycle.getParts().containsKey(partCategory)) {
                throw new RuntimeException("Map already contains");
            }

        }

    }



    public void saveBicycles(String filename) throws IOException{
        File file = new File (filename,"rower.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        for(Bicycle bicycle : bicycles) {
            out.write(bicycle.toString());
        }
        out.close();

    }

    public void loadBicycles(String filename) throws IOException{
        Path path = Paths.get("rower.txt");
        byte[] data = Files.readAllBytes(path);
        System.out.println(new String(data, 0));
    }


    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
            System.out.println("-------");
            }
        }

    }


