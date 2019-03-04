package p76.bicycles.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import p76.bicycles.dto.*;

@Data
public class BicycleService {
    ObjectMapper mapper = new ObjectMapper();
    public List<Bicycle> bicycles;
    GeneratorID generator;


    public BicycleService() {
        init();
    }


    private void init() {
        mapper = new ObjectMapper();
        bicycles =  new ArrayList();
        generator = new GeneratorID(bicycles);
    }

    public void addBicycles(List<Bicycle> bicycles) {
        for(Bicycle bicycle : bicycles) {
            addBicycle(bicycle);
        }
    }

    public Bicycle findBicycle(String name) {
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getName().equals(name)) {
                return bicycle;
            }
        }
        return null;
    }

    public synchronized void addBicycle(Bicycle newBicycle) {
        newBicycle.setId(generator.generateNewId());
        bicycles.add(newBicycle);
    }

    public synchronized void addBicycle(String name, String brand) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);
        newBicycle.setManufacturer(brand);
        newBicycle.setId(generator.generateNewId());
        bicycles.add(newBicycle);
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
        init();
        File file = new File(filename);
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


