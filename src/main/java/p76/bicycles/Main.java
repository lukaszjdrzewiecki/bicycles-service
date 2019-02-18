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
        BicycleCompatibility compability = new BicycleCompatibility();

        service.addBicycle("Sportster 2017", "Scott");
        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");


        service.addBicyclePart("Sportster 2017", new RearDerailleur("M590", 11, "Long", 10));
        service.addBicyclePart("Sportster 2017", new Crank("Deore", 3,44, 36, 22, 10));
        service.addBicyclePart("Tormenta Lady", new Crank("Alivio"));
        service.addBicyclePart("Sportster 2017", new FrontDerailleur("Alivio"));
        service.addBicyclePart("Trans Siberian 2015", new Brakes( "Altus"));
        service.addBicyclePart("Sportster 2017", new Wheels("XT"));
        service.addBicyclePart("Sportster 2017", new Casette("M590", 11, 36, 10));


        List<Bicycle> randomBicycles = random.generateRandomBicycles(15);
        service.addBicycles(randomBicycles);

        String fileName = "bicycles.txt";

        service.saveBicycles(fileName);
        service.loadBicycles(fileName);
        service.printBicycles();


        System.out.println("--------------------------- \n \n \n" );

        //compability.rearDerailleurCompability(service.findBicycle("Sportster 2017"));



    }

}
