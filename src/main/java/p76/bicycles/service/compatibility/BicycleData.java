package p76.bicycles.service.compatibility;

import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

@Component
public class BicycleData {

    public double bicycleWeight (Bicycle bicycle) {
        double weight = 0.0;
        weight += bicycle.getFrame().getWeight();
        weight += bicycle.getFork().getWeight();
        return weight;
    }
}
