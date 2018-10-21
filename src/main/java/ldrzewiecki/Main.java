package ldrzewiecki;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BicycleService service = new BicycleService();
        service.addBicycle("SCOTT Sportster 2017");
        service.addBicycle("ACCENT Tormenta Lady");
        service.addBicycle("SCOTT Scale Unique");
        service.addBicycle("KROSS Trans Siberian 2015");


        service.addBicyclePart("SCOTT Sportster 2017", BicyclePartCategory.CRANK, "Deore");
        service.addBicyclePart("ACCENT Tormenta Lady", BicyclePartCategory.CRANK, "Alivio");
        service.addBicyclePart("SCOTT Sportster 2017", BicyclePartCategory.FRONT_DERAILLEUR, "Alivio");
        service.addBicyclePart("KROSS Trans Siberian 2015", BicyclePartCategory.BRAKES, "Altus");
        service.addBicyclePart("SCOTT Sportster 2017", BicyclePartCategory.WHEELS, "Deore XT");
        service.addBicyclePart("ACCENT Tormenta Lady", BicyclePartCategory.CRANK, "Deore");
        service.addBicyclePart("ACCENT Tormenta Lady", BicyclePartCategory.CRANK, "blablalba");



        service.printBicycles();

    }

}
