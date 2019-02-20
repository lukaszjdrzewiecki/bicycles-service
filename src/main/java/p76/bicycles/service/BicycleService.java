package p76.bicycles.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import p76.bicycles.dto.*;

public class BicycleService {
    public List<Bicycle> bicycles = new ArrayList();
    GeneratorID generator = new GeneratorID();



    ObjectMapper mapper = new ObjectMapper();

    public void addBicycles(List<Bicycle> bicycles) {
        this.bicycles.addAll(bicycles);
    }

    public Bicycle findBicycle(String name) {
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getName().equals(name)) {
                return bicycle;
            }
        }
        return null;
    }


    public void addBicycle(String name, String brand) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);
        newBicycle.setManufacturer(brand);
        Bicycle bicycle = findBicycle(name);
        if (bicycle != null) {
            throw new RuntimeException("You are trying to add the same name two times");
        }
        bicycles.add(newBicycle);
        newBicycle.setID(generator.findMaxID());
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



}


