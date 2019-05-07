package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.service.BicycleService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfoService {

    @Autowired
    BicycleService service;

    private double bicycleWeight(Bicycle bicycle) {
        try {
            double weight = 0.0;
            weight += bicycle.getFrame().getWeight();
            weight += bicycle.getFork().getWeight();
            weight += bicycle.getRearDerailleur().getWeight();
            weight += bicycle.getFrontDerailleur().getWeight();
            weight += bicycle.getBrakeFront().getWeight();
            weight += bicycle.getHandlebar().getWeight();
            return weight;
        } catch (Exception e) {
            return 0.0;
        }
    }

    public InfoResult getInfoResult(Bicycle bicycle) {
        try {
            InfoResult info = new InfoResult(
                    bicycle.getFrame().getName(),
                    bicycle.getFrame().getPurpose(),
                    bicycleWeight(bicycle),
                    bicycle.getRearDerailleur().getSpeeds(),
                    bicycle.getCrank().getNumberOfGears());
            return info;
        } catch (Exception e) {
            return null;
        }
    }

    public List<InfoResult> getInfoResults() {
        List<InfoResult> result = new ArrayList<>();

        List<Bicycle> bicycles = service.findAllBicycles();
        for (Bicycle bicycle : bicycles) {
            InfoResult info = getInfoResult(bicycle);
            result.add(info);
        }

        return result;
    }

}
