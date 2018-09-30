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
        service.addBicycle("Accent Tormenta Lady");
        service.addBicycle("Scott Scale Unique");
        service.addBicycle("Kross Trans Siberian 2015");


        service.addBicyclePart("SCOTT Sportster 2017", "korba", "Deore");


    }

}
