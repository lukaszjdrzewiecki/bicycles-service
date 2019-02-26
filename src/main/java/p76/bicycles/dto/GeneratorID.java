package p76.bicycles.dto;

import p76.bicycles.service.BicycleService;

import java.util.ArrayList;
import java.util.List;

public class GeneratorID {
    List<Bicycle> bicycles;

    public GeneratorID(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }

    public long generateNewId(){
        long maxId = 0;
        for (Bicycle bicycle : bicycles) {
            if ((bicycle.getId() > maxId)) {
                maxId = bicycle.getId();
            }
        }
        return maxId + 1;
    }
}
