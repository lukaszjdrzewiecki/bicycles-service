package p76.bicycles;

import p76.bicycles.dto.*;
import p76.bicycles.service.BicycleCompatibility;
import p76.bicycles.service.BicycleGenerator;
import p76.bicycles.service.BicycleService;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BicycleService service = new BicycleService();
        BicycleGenerator random = new BicycleGenerator();
        BicycleCompatibility compatibility = new BicycleCompatibility();


        List<Bicycle> randomBicycles = random.generateRandomBicycles(15);
        service.addBicycles(randomBicycles);

        String fileName = "bicycles.txt";

        // service.printBicycles();


        //compatibility.bicycleCheck(service.findBicycle("Sportster 2017"));

        System.out.println("====================================\n\n\n");
        //compatibility.changeCasette(service.findBicycle("Sportster 2017"), new Casette("M8000", 11, 46, 10));

    }


}
