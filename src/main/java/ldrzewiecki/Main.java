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



        service.addBicyclePart("SCOTT Sportster 2017", "CRANK", "Deore");
        service.addBicyclePart("ACCENT Tormenta Lady", "CRANK", "Alivio");
        service.addBicyclePart("SCOTT Sportster 2017", "FRONTDERAILLEUR", "Alivio");
        service.addBicyclePart("KROSS Trans Siberian 2015", "BRAKES", "Altus");
        service.addBicyclePart("SCOTT Sportster 2017", "WHEELS", "Deore XT");



        service.printBicycles();
    }

}
