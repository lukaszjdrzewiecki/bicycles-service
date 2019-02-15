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
import ldrzewiecki.dto.Bicycle;
import ldrzewiecki.dto.BicyclePart;
import ldrzewiecki.dto.Crank;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();
    List<Bicycle> randomBicycles = new ArrayList<>();

    ObjectMapper mapper = new ObjectMapper();

    public List addRandomBicycles(int number){
        for (int i =0; i<number; i++){
            this.randomBicycles.add(new Bicycle("Rower #" + (i+1)));
        }
        return randomBicycles;
    }

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


    public void addBicyclePart(String bicycleName, BicyclePart part) {
        Bicycle bicycle = findBicycle(bicycleName);
        if (bicycle != null) {
            if(part instanceof Crank) {
                bicycle.setCrank((Crank)part);
            }
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

    public void printBicycles(List list) {
        for (Object bicycle : list) {
            System.out.println(bicycle);
        }
    }


}


