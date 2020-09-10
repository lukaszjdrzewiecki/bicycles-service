package workshop.service;

import workshop.db.entity.*;
import workshop.db.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BicycleGenerator {

    private static final String[] brand = {"Scott", "Kross", "Orbea", "Cube", "Fuji"};

    private static final String[] partSeries = {"Altus", "Alivio", "Deore", "XT", "XTR"};


    public List generateRandomBicycles(int noOfBicycles) {
        List<Bicycle> randomBicycles = new ArrayList();
        for (int i = 0; i < noOfBicycles; i++) {
            randomBicycles.add(createRandomBicycle());
        }
        return randomBicycles;
    }

    public Bicycle createRandomBicycle() {
        Bicycle bicycle = new Bicycle();
        //bicycle.setName("Losowy Rower");
        //bicycle.setManufacturer(getRandomManufacturer());
        //bicycle.setCrank(new Crank(getRandomPartSeries()));
        //bicycle.setCassette(new Cassette(getRandomPartSeries()));
        //bicycle.setRearDerailleur(new RearDerailleur(getRandomPartSeries()));
        //bicycle.setBrakeCaliper(new BrakeCaliper(getRandomPartSeries()));
       // bicycle.setFrontDerailleur(new FrontDerailleur(getRandomPartSeries()));
        return bicycle;
    }

    String getRandomManufacturer() {
        return brand[getRandomNumberInRange(0, brand.length - 1)];
    }

    String getRandomPartSeries() {
        return partSeries[getRandomNumberInRange(0, partSeries.length - 1)];
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }
}