package ldrzewiecki;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> bicycle = new HashMap();
        bicycle.put("Casette", "CS M41");
        bicycle.put("Front Deraileur", "Altus");
        bicycle.put("Rear Deraileur", "Altus");
        bicycle.put("Crank", "Deore");
        bicycle.put("Chain", "Alivio");

        String[] keys = bicycle.keySet().toArray(new String [bicycle.size()]);
        System.out.println(keys);

        for (Map.Entry x : bicycle.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
            Writer output;
            output = new BufferedWriter(new FileWriter("Bicycle.txt", true));
            output.write(x.getKey() + " " + x.getValue());
        }
    }

}
