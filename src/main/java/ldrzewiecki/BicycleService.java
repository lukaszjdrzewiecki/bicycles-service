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
import java.util.*;

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



    public void addBicyclePart(String bicycleName, BicyclePartCategory partCategory, String partName) {
        Bicycle bicycle = findBicycle(bicycleName);
        if (bicycle != null) {
            BicyclePart newBicyclePart = new BicyclePart(partCategory, partName);
            if (!bicycle.getParts().containsKey(partCategory)){
                    bicycle.getParts().put(partCategory, newBicyclePart);
                } else {throw new RuntimeException("duplikat");}
        }
    }


    public void saveBicycles(String filename) throws IOException{
        File file = new File (filename);
        BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
        for(Bicycle bicycle : bicycles) {
            out.write(bicycle.getName() + "\t");
            for(BicyclePartCategory partCategory : bicycle.getParts().keySet()) {
                out.write( partCategory + "=" + bicycle.getParts().get(partCategory));
                out.write(";");
            }
            out.write("\n");
        }
        out.close();
    }


    public void loadBicycles(String filename) throws IOException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        this.bicycles.clear();
        while(sc.hasNextLine()) {
            String[] bicycleInfo = sc.nextLine().split("\t");
            String bicycleName = bicycleInfo[0];
            this.addBicycle(bicycleName);
            try {
                String[] partsInfo = bicycleInfo[1].split(";");
                for (String partInfo : partsInfo) {
                    String[] part = partInfo.split("=");
                    this.addBicyclePart(bicycleName, BicyclePartCategory.valueOf(part[0]), part[1]);
                }
            } catch (Exception e) {
                //handling end of part list
            }

        }
    }

    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
        }
    }
}


