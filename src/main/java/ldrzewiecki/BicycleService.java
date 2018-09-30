package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();

    public void addBicycle(String name) {
        Bicycle bicycle = new Bicycle();
        bicycle.setName(name);

        bicycles.add(bicycle);
    }
}
