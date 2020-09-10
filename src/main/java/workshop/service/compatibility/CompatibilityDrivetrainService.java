package workshop.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import workshop.db.dto.CompatibilityResult;
import workshop.db.entity.Bicycle;
import workshop.db.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompatibilityDrivetrainService {

    private final Utils utils;

    static private int drivetrainCapacity(Bicycle bicycle) {
        return (bicycle.getCassette().getBiggest() - bicycle.getCassette().getSmallest())
                + (bicycle.getCrank().getBigGear().getTeethNumber() - bicycle.getCrank().getSmallGear().getTeethNumber());
    }

    Boolean isDrivetrainCapacityCompatible(Bicycle bicycle) {
        return bicycle.getRearDerailleur().getCapacity() >= drivetrainCapacity(bicycle);
    }

    Boolean areAllTheComponentsSameSpeeds(Bicycle bicycle) {
        return allEqual(
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

    private boolean allEqual(int... integers) {
        return Arrays.stream(integers)
                .boxed()
                .collect(Collectors.toSet()).size() == 1;
    }

    private CompatibilityResult maxCassetteCheck(Bicycle bicycle) {
        return CompatibilityResult.builder()
                .name("Max cassette available for this bicycle")
                .value(null)
                .message(utils.printMessage(false, maxCassetteMessage(bicycle)))
                .build();
    }

    private CompatibilityResult capacityCheck(Bicycle bicycle) {
        boolean isCompatible = isDrivetrainCapacityCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Front wheel rim and tyre diameter check")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible, drivetrainCapacityMessage(bicycle)))
                .build();
    }

    private CompatibilityResult speedsCheck(Bicycle bicycle) {
        boolean isCompatible = areAllTheComponentsSameSpeeds(bicycle);

        return CompatibilityResult.builder()
                .name("Front wheel rim and tyre diameter check")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible, speedsMessage(bicycle)))
                .build();
    }

    //messages

    private static String maxCassetteMessage(Bicycle bicycle) {
        try {
            return " Biggest possible gear in your cassette is " + ((bicycle.getRearDerailleur().getCapacity() - drivetrainCapacity(bicycle) + bicycle.getCassette().getBiggest()));
        } catch (Exception e) {
            return null;
        }
    }

    private static String drivetrainCapacityMessage(Bicycle bicycle) {
        try {
            return " Rear derailleur capacity: " + ((bicycle.getRearDerailleur().getCapacity() +
                    " | drivetrain requires: " + drivetrainCapacity(bicycle)));
        } catch (Exception e) {
            return null;
        }
    }

    private static String speedsMessage(Bicycle bicycle) {
        try {
            return " Cassette speeds: " + bicycle.getCassette().getSpeeds() +
                    " | Rear Derailleur speeds: " + bicycle.getRearDerailleur().getSpeeds() +
                    " | Crank Speeds " + bicycle.getCrank().getSpeeds() +
                    " | Front Derailleur speeds " + bicycle.getFrontDerailleur().getSpeeds();
        } catch (Exception e) {
            return null;
        }
    }
}
