package p76.bicycles.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import p76.bicycles.dto.*;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();
    List<Bicycle> randomBicycles = new ArrayList<>();

    ObjectMapper mapper = new ObjectMapper();

    public List addRandomBicycles(int number){
        for (int i =0; i<number; i++){
            this.randomBicycles.add(new Bicycle("Rower #" + (i+1), "RANDOM"));
        }
        return randomBicycles;
    }

    public List addRandomParts(String name){
        for (Bicycle bicycle : randomBicycles){
            bicycle.setCrank( new Crank(name));
            bicycle.setCasette( new Casette(name));
            bicycle.setRearDerailleur( new RearDerailleur(name));
            bicycle.setWheels( new Wheels(name));
            bicycle.setBrakes( new Brakes(name));
            bicycle.setFrontDerailleur( new FrontDerailleur(name));
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


    public void addBicycle(String name, String brand) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);
        newBicycle.setManufacturer(brand);
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


