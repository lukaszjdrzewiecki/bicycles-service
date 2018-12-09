package ldrzewiecki;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();

    ObjectMapper mapper = new ObjectMapper();

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
            throw new RuntimeException("You are trying to add the same name two times");
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


    public void saveBicycles(String filename){
        File file = new File (filename);
        try {
            mapper.writeValue(file, bicycles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadBicycles(String filename) {
        File file = new File(filename);
        this.bicycles.clear();
        try {
            Bicycle[] bicycle = mapper.readValue(file, Bicycle[].class);
            List<Bicycle> arrayList = new ArrayList<>(Arrays.asList(bicycle));
            bicycles.addAll(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
        }
    }

    public int getNoOfBicycles() {
        return bicycles.size();
    }
}


