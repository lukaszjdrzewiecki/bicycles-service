package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Drivetrain.Cassette;

import static p76.bicycles.service.compatibility.Messages.*;
import static p76.bicycles.service.compatibility.Messages.CHANGING_COMPONENT;

@Component
public class DrivetrainCompatibilityService {

    @Autowired
    DataService dataService;

    private int drivetrainCapacity(Bicycle bicycle) {
        return (bicycle.getCassette().getMaximum() - bicycle.getCassette().getMinimum())
                + (bicycle.getCrank().getBigGear().getTeethNumber() - bicycle.getCrank().getSmallGear().getTeethNumber());
    }


    public Boolean drivetrainCheck(Bicycle bicycle) {
        try {
            if (bicycle.getRearDerailleur().getCapacity() >= drivetrainCapacity(bicycle)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public void drivetrainCheckPrint(Bicycle bicycle) {
        if (drivetrainCheck(bicycle)) {
            System.out.println(DRIVETRAIN_CHECK + COMPATIBLE_ALL);
        } else {
            System.out.println(DRIVETRAIN_CHECK + COMPATIBLE_NOT);
            System.out.println(DRIVETRAIN_CHECK + DRIVETRAIN_EXPLANATION + (bicycle.getRearDerailleur().getCapacity() - drivetrainCapacity(bicycle) + bicycle.getCassette().getMaximum()));
        }
    }

    public void changeCasette(Bicycle bicycle, Cassette cassette) {
        System.out.println(CHANGING_COMPONENT);
        bicycle.setCassette(cassette);
        drivetrainCheckPrint(bicycle);
    }
}
