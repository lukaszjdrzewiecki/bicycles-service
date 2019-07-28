package p76.bicycles.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
@RequiredArgsConstructor
public class CompatibilityDrivetrainService {

    private final DataService dataService;
    private final Messages messages;

    static private int drivetrainCapacity(Bicycle bicycle) {
        return (bicycle.getCassette().getBiggest() - bicycle.getCassette().getSmallest())
                + (bicycle.getCrank().getBigGear().getTeethNumber() - bicycle.getCrank().getSmallGear().getTeethNumber());
    }

    Boolean isDrivetrainCapacityCompatible(Bicycle bicycle) {
        return bicycle.getRearDerailleur().getCapacity() >= drivetrainCapacity(bicycle);
    }

    Boolean areAllTheComponentsSameSpeeds(Bicycle bicycle) {
        return dataService.allEqual(
                bicycle.getCassette().getSpeeds(),
                bicycle.getRearDerailleur().getSpeeds(),
                bicycle.getChain().getSpeeds(),
                bicycle.getCrank().getSpeeds()
        );
    }

    List<CompatibilityResult> drivetrainCheckTests(Bicycle bicycle) {
        return List.of(
                maxCassetteCheck(bicycle),
                capacityCheck(bicycle),
                speedsCheck(bicycle)
        );
    }

    private CompatibilityResult maxCassetteCheck(Bicycle bicycle) {
        return CompatibilityResult.builder()
                .name("Max cassette available for this bicycle")
                .value(null)
                .message(messages.printMessage(false, maxCassetteMessage(bicycle)))
                .build();
    }

    private CompatibilityResult capacityCheck(Bicycle bicycle) {
        boolean isCompatible = isDrivetrainCapacityCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Front wheel rim and tyre diameter check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, drivetrainCapacityMessage(bicycle)))
                .build();
    }

    private CompatibilityResult speedsCheck(Bicycle bicycle) {
        boolean isCompatible = areAllTheComponentsSameSpeeds(bicycle);

        return CompatibilityResult.builder()
                .name("Front wheel rim and tyre diameter check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, speedsMessage(bicycle)))
                .build();
    }

    //messages

    final public String maxCassetteMessage(Bicycle bicycle) {
        try {
            return " Biggest possible gear in your cassette is " + ((bicycle.getRearDerailleur().getCapacity() - drivetrainCapacity(bicycle) + bicycle.getCassette().getBiggest()));
        } catch (Exception e) {
            return null;
        }
    }

    final public String drivetrainCapacityMessage(Bicycle bicycle) {
        try {
            return " Rear derailleur capacity: " + ((bicycle.getRearDerailleur().getCapacity() +
                    " | drivetrain requires: " + drivetrainCapacity(bicycle)));
        } catch (Exception e) {
            return null;
        }
    }

}
