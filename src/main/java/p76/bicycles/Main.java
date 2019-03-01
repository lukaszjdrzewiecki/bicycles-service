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


        service.addBicycle("Sportster 2017", "Scott");
        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");


        service.findBicycle("Sportster 2017").setCrank(new Crank("Deore", 3, 42, 36, 22, 10));
        service.findBicycle("Sportster 2017").setRearDerailleur(new RearDerailleur("RD-M8000", 10, "Long", 47));
        service.findBicycle("Sportster 2017").setCasette(new Casette("M590", 11, 36, 10));
        service.findBicycle("Sportster 2017").setFrontWheel(new FrontWheel(
                new Rim("Shimano HB900", 20, 25, 32, true, true, 622),
                new Hub("HOPE HB4", 28, 130, true, 15),
                new Tyre("Continental Baron", 27, true, 622)));


        List<Bicycle> randomBicycles = random.generateRandomBicycles(15);
        service.addBicycles(randomBicycles);

        String fileName = "bicycles.txt";

        service.saveBicycles(fileName);
        service.loadBicycles(fileName);
        // service.printBicycles();


        compatibility.bicycleCheck(service.findBicycle("Sportster 2017"));

        System.out.println("====================================\n\n\n");
        compatibility.changeCasette(service.findBicycle("Sportster 2017"), new Casette("M8000", 11, 46, 10));

    }


}
