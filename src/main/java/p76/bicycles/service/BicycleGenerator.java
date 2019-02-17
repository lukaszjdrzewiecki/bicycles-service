package p76.bicycles.service;

import p76.bicycles.dto.*;

import java.util.ArrayList;
import java.util.List;

public class BicycleGenerator {

    List<Bicycle> randomBicycles = new ArrayList<>();

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

    public void printBicycles(List list) {
        for (Object bicycle : list) {
            System.out.println(bicycle);
        }
    }
}
