package workshop.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workshop.db.dto.InfoResult;
import workshop.db.entity.Bicycle;
import workshop.service.BicycleService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfoService {

    @Autowired
    BicycleService service;

//    private double bicycleWeight(Bicycle bicycle) {
//        double spokes = bicycle.getRimRear().getHoles()* 2 * 0.0069;
//        try {
//            double weight = 0.0;
//            weight += bicycle.getFrame().getWeight();
//            weight += bicycle.getFork().getWeight();
//
//            weight += bicycle.getCrank().getWeight();
//            weight += bicycle.getCrank().getBigGear().getWeight();
//            weight += bicycle.getBottomBracket().getWeight();
//            weight += bicycle.getRearDerailleur().getWeight();
//            try {
//            weight += bicycle.getFrontDerailleur().getWeight();
//            } catch (Exception e) {
//                weight += 0;
//            }
//            try {
//            weight += bicycle.getShifterLeft().getWeight();
//            } catch (Exception e) {
//                weight += 0;
//            }
//            weight += bicycle.getShifterRight().getWeight();
//            weight += bicycle.getCassette().getWeight();
//            weight += bicycle.getChain().getWeight();
//
//            weight += bicycle.getBrakeHydraulicFront().getWeight();
//            weight += bicycle.getBrakeHydraulicRear().getWeight();
//
//            //weight += bicycle.getHandlebar().getWeight();
//            weight += bicycle.getStem().getWeight();
//            weight += bicycle.getGrips().getWeight();
//            weight += bicycle.getHeadSet().getWeight();
//
//            weight += bicycle.getHubFront().getWeight();
//            weight += bicycle.getRimFront().getWeight();
//            weight += bicycle.getTyreFront().getWeight();
//            weight += bicycle.getDiscFront().getWeight();
//
//            weight += bicycle.getHubRear().getWeight();
//            weight += bicycle.getRimRear().getWeight();
//            weight += bicycle.getTyreRear().getWeight();
//            weight += bicycle.getDiscRear().getWeight();
//
//            weight += bicycle.getSeatpost().getWeight();
//            weight += bicycle.getSeatPostClamp().getWeight();
//            weight += bicycle.getSaddle().getWeight();
//
//            weight += 0.600; //inner tubes
//            weight += 0.200; //cables
//            weight += 0.400; //pedals
//            weight += spokes;
//
//            return weight;
//        } catch (Exception e) {
//            return 0.0;
//        }
//    }
//
//    public InfoResult getInfoResult(Bicycle bicycle) {
//        try {
//            InfoResult info = new InfoResult(
//                    bicycle.getFrame().getBrand(),
//                    bicycle.getFrame().getName(),
//                    bicycle.getFrame().getPurpose(),
//                    bicycleWeight(bicycle),
//                    bicycle.getRearDerailleur().getSpeeds(),
//                    bicycle.getCrank().getNumberOfGears());
//            return info;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public List<InfoResult> getInfoResults() {
//        List<InfoResult> result = new ArrayList<>();
//
//        List<Bicycle> bicycles = service.findAllBicycles();
//        for (Bicycle bicycle : bicycles) {
//            InfoResult info = getInfoResult(bicycle);
//            result.add(info);
//        }
//
//        return result;
//    }

}
