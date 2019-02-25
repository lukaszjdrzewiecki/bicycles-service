package p76.bicycles.dto;

import p76.bicycles.service.BicycleService;

import java.util.ArrayList;
import java.util.List;

public class GeneratorID {
    private long maxID = 1;
    private BicycleService service;

    public synchronized Long createID()
    {
        return Long.valueOf(maxID++);
    }

    public long findMaxID(){
        service = new BicycleService();
        for (Bicycle bicycle : service.getBicyclesList()) {
            if (bicycle.getID() < maxID) {
                return createID();
            }
        }
        return -1;
    }

}
