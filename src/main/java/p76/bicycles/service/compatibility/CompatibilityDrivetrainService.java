package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class CompatibilityDrivetrainService {

    @Autowired
    DataService dataService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> drivetrainCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        drivetrainChecks(result, bicycle);
        return result;
    }

    private void drivetrainChecks(List<CompatibilityResult> result, Bicycle bicycle) {
        result.add(new CompatibilityResult("Max Cassette" + CHECK, drivetrainCapacityCheck(bicycle), messages.printMessage(drivetrainCapacityCheck(bicycle), messages.maxCassetteMessage(bicycle))));
        result.add(new CompatibilityResult("Capacity" + CHECK, drivetrainCapacityCheck(bicycle), messages.printMessage(drivetrainCapacityCheck(bicycle), messages.drivetrainCapacityMessage(bicycle))));
        result.add(new CompatibilityResult("Speeds number" + CHECK, speedsCompatibilityCheck(bicycle), messages.printMessage(speedsCompatibilityCheck(bicycle), speedsMessage(bicycle))));
    }

    protected int drivetrainCapacity(Bicycle bicycle) {
        try {
            return (bicycle.getCassette().getMaximum() - bicycle.getCassette().getMinimum())
                    + (bicycle.getCrank().getBigGear().getTeethNumber() - bicycle.getCrank().getSmallGear().getTeethNumber());
        } catch (Exception e) {
            return -1;
        }
    }


    public Boolean drivetrainCapacityCheck(Bicycle bicycle) {
        try {
            if (bicycle.getRearDerailleur().getCapacity() >= drivetrainCapacity(bicycle)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean speedsCompatibilityCheck(Bicycle bicycle) {
        try {
            if (dataService.allEqual(bicycle.getCassette().getSpeeds(), bicycle.getRearDerailleur().getSpeeds(), bicycle.getCrank().getSpeeds())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

}
