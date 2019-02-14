package ldrzewiecki;

import ldrzewiecki.dto.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.File;


public class Main {
    public static void main(String[] args) throws IOException {

        BicycleService service = new BicycleService();



        service.addBicycle("SCOTT Sportster 2017");
        service.addBicycle("ACCENT Tormenta Lady");
        service.addBicycle("SCOTT Scale Unique");
        service.addBicycle("KROSS Trans Siberian 2015");

        service.addBicyclePart("SCOTT Sportster 2017", new Crank("Deore", 3,44, 36, 22, 10));
        service.addBicyclePart("ACCENT Tormenta Lady", new Crank("Alivio"));
        service.addBicyclePart("SCOTT Sportster 2017", new FrontDerailleur("Alivio"));
        service.addBicyclePart("KROSS Trans Siberian 2015", new Brakes( "Altus"));
        service.addBicyclePart("SCOTT Sportster 2017", new Wheels("XT"));
        service.addBicyclePart("Scott Sportster 2017", new Casette("M590", 11, 36, 10));

        String fileName = "bicycles.txt";

        service.saveBicycles(fileName);
        service.loadBicycles(fileName);
        service.printBicycles();

    }

}
