package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class SpeedsCompatibilityService {

    @Autowired
    Common common;

    Boolean speedsCompatibilityCheck(Bicycle bicycle) {
        try {
            if (common.allEqual(bicycle.getCassette().getSpeed(), bicycle.getRearDerailleur().getSpeed(), bicycle.getCrank().getSpeed())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public void speedsCompatibilityCheckPrint(Bicycle bicycle) {
        if (speedsCompatibilityCheck(bicycle)) {
            System.out.println(NUMBER_SPEEDS_CHECK + COMPATIBLE_ALL);
        } else {
            System.out.println(NUMBER_SPEEDS_CHECK + COMPATIBLE_NOT);
        }
    }
}
