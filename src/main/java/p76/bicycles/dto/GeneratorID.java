package p76.bicycles.dto;

import p76.bicycles.service.BicycleService;

import java.util.ArrayList;

public class GeneratorID {
    private long maxID = 1;

    public synchronized Long createID()
    {
        return Long.valueOf(maxID++);
    }

    public long findMaxID(){
        BicycleService service = new BicycleService();
        ArrayList<Bicycle> bicycles = new ArrayList<>();
        service.loadBicycles("bicycles.txt", bicycles);
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getId() < maxID) {
                return createID();
            }
        }
        return -1;
    }

}
