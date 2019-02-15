package ldrzewiecki;

import ldrzewiecki.dto.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.File;


public class Main {
    public static void main(String[] args) throws IOException {

        BicycleService service = new BicycleService();

        service.addBicycle("Sportster 2017", "Scott");
        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");

        service.addBicyclePart("Sportster 2017", new Crank("Deore", 3,44, 36, 22, 10));
        service.addBicyclePart("Tormenta Lady", new Crank("Alivio"));
        service.addBicyclePart("Sportster 2017", new FrontDerailleur("Alivio"));
        service.addBicyclePart("Trans Siberian 2015", new Brakes( "Altus"));
        service.addBicyclePart("Sportster 2017", new Wheels("XT"));
        service.addBicyclePart("Sportster 2017", new Casette("M590", 11, 36, 10));

        String fileName = "bicycles.txt";

        service.saveBicycles(fileName);
        service.loadBicycles(fileName);
        service.printBicycles();

        service.printBicycles(service.addRandomBicycles(15));

    }

}
