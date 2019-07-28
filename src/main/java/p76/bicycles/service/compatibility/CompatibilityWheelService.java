package p76.bicycles.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CompatibilityWheelService {

    private final Messages messages;

    private static Boolean isFrontRimToTyreDiameterCompatible(Bicycle bicycle) {
        return bicycle.getRimFront().getDiameter() == bicycle.getTyreFront().getDiameter();
    }

    private static Boolean isFrontNumberOfHolesCompatible(Bicycle bicycle) {
        return bicycle.getRimFront().getHoles() == bicycle.getHubFront().getHoles();
    }

    List<CompatibilityResult> frontWheelCheckTests(Bicycle bicycle) {
        return List.of(
                frontWheelDiameterCheck(bicycle),
                frontWheelRimToTyreSizeCheck(bicycle),
                frontWheelHolesCheck(bicycle)
        );
    }

    Boolean isFrontWheelCompatible(Bicycle bicycle) {
        return isFrontRimToTyreDiameterCompatible(bicycle) && isFrontNumberOfHolesCompatible(bicycle);
    }

    private CompatibilityResult frontWheelDiameterCheck(Bicycle bicycle) {
        boolean isCompatible = isFrontRimToTyreDiameterCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Front wheel rim and tyre diameter check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.wheelDiameterMessageFront(bicycle)))
                .build();
    }

    private CompatibilityResult frontWheelRimToTyreSizeCheck(Bicycle bicycle) {
        boolean isCompatible = isRimToTyreWidthCompatible(
                bicycle.getTyreFront().getWidth(),
                bicycle.getRimFront().getInnerWidth());

        return CompatibilityResult.builder()
                .name("Front wheel rim and tyre width check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, rimTyreMessageFront(bicycle)))
                .build();
    }

    private CompatibilityResult frontWheelHolesCheck(Bicycle bicycle) {
        boolean isCompatible = isFrontNumberOfHolesCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Front wheel number of holes check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.wheelHolesMessageFront(bicycle)))
                .build();
    }

    // FRONT WHEEL
    //----------------------
    // REAR WHEEL

    private static Boolean isRearRimToTyreDiameterCompatible(Bicycle bicycle) {
        return bicycle.getRimRear().getDiameter() == bicycle.getTyreRear().getDiameter();
    }

    private static Boolean isRearNumberOfHolesCompatible(Bicycle bicycle) {
        return bicycle.getRimRear().getHoles() == bicycle.getHubRear().getHoles();
    }

    List<CompatibilityResult> rearWheelCheckTests(Bicycle bicycle) {
        return List.of(
                rearWheelDiameterCheck(bicycle),
                rearWheelRimToTyreSizeCheck(bicycle),
                rearWheelHolesCheck(bicycle)
        );
    }

    Boolean isRearWheelCompatible(Bicycle bicycle) {
        return isRearRimToTyreDiameterCompatible(bicycle) && isRearNumberOfHolesCompatible(bicycle);
    }

    private CompatibilityResult rearWheelDiameterCheck(Bicycle bicycle) {
        boolean isCompatible = isRearRimToTyreDiameterCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Rear wheel rim and tyre diameter check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.wheelDiameterMessageRear(bicycle)))
                .build();
    }

    private CompatibilityResult rearWheelRimToTyreSizeCheck(Bicycle bicycle) {
        boolean isCompatible = isRimToTyreWidthCompatible(
                bicycle.getTyreFront().getWidth(),
                bicycle.getRimFront().getInnerWidth());

        return CompatibilityResult.builder()
                .name("Rear wheel rim and tyre width check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, rimTyreMessageRear(bicycle)))
                .build();
    }

    private CompatibilityResult rearWheelHolesCheck(Bicycle bicycle) {
        boolean isCompatible = isRearNumberOfHolesCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Rear wheel number of holes check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.wheelHolesMessageRear(bicycle)))
                .build();
    }

    // Utilities

    private static Boolean isRimToTyreWidthCompatible(int tyreWidth, double rimWidth) {
        int tyre = tyreWidth;
        List<Integer> rangeList = tyreRimRangeFront(rimWidth);
        int min = rangeList.get(0);
        int max = rangeList.get(1);
        return (tyre >= min && tyre <= max);
    }

    public static List<Integer> tyreRimRangeFront(double rimWidth) {
        double rim = rimWidth;
        double temp = 0;
        for (double key : DIAMETERS_MAP.keySet()) {
            if (rim == key) {
                temp = key;
            }
        }
        return DIAMETERS_MAP.get(temp);

    }

    private static final Map<Double, List<Integer>> DIAMETERS_MAP = Collections.unmodifiableMap(Map.ofEntries(
            Map.entry(13.0, List.of(18, 25)),
            Map.entry(15.0, List.of(23, 32)),
            Map.entry(17.0, List.of(25, 52)),
            Map.entry(19.0, List.of(28, 62)),
            Map.entry(20.0, List.of(28, 62)),
            Map.entry(21.0, List.of(35, 62)),
            Map.entry(23.0, List.of(37, 62)),
            Map.entry(25.0, List.of(42, 62)),
            Map.entry(29.0, List.of(47, 62)),
            Map.entry(30.0, List.of(52, 62)),
            Map.entry(35.0, List.of(60, 75)),
            Map.entry(40.0, List.of(65, 75)),
            Map.entry(45.0, List.of(70, 75))
    ));

    //messages

    final String rimTyreMessageRear(Bicycle bicycle) {
        double width = bicycle.getRimRear().getInnerWidth();

        try {
            return ": your rim width equals " + width +
                    " mm and thus recommended size of a tyre is " +
                    tyreRimRangeFront(width).get(0) + " - " +
                    tyreRimRangeFront(width).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    final String rimTyreMessageFront(Bicycle bicycle) {
        double width = bicycle.getRimFront().getInnerWidth();

        try {
            return ": your rim width equals " + width +
                    " mm and thus recommended size of a tyre is " +
                    tyreRimRangeFront(width).get(0) + " - " +
                    tyreRimRangeFront(width).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }

}
