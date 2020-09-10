package workshop.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import workshop.db.dto.CompatibilityResult;
import workshop.db.entity.Bicycle;
import workshop.db.utils.Utils;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CompatibilityWheelService {

    private final Utils utils;

//    private static Boolean isFrontRimToTyreDiameterCompatible(Bicycle bicycle) {
//        return bicycle.getRimFront().getDiameter() == bicycle.getTyreFront().getDiameter();
//    }
//
//    private static Boolean isFrontNumberOfHolesCompatible(Bicycle bicycle) {
//        return bicycle.getRimFront().getHoles() == bicycle.getHubFront().getHoles();
//    }

//    List<CompatibilityResult> frontWheelCheckTests(Bicycle bicycle) {
//        return List.of(
//                frontWheelDiameterCheck(bicycle),
//                frontWheelRimToTyreSizeCheck(bicycle),
//                frontWheelHolesCheck(bicycle)
//        );
//    }
//
//    Boolean isFrontWheelCompatible(Bicycle bicycle) {
//        return isFrontRimToTyreDiameterCompatible(bicycle) && isFrontNumberOfHolesCompatible(bicycle);
//    }
//
//    private CompatibilityResult frontWheelDiameterCheck(Bicycle bicycle) {
//        boolean isCompatible = isFrontRimToTyreDiameterCompatible(bicycle);
//
//        return CompatibilityResult.builder()
//                .name("Front wheel rim and tyre diameter check")
//                .value(isCompatible)
//                .message(utils.printMessage(isCompatible,
//                        RIM_DIAMETER_MESSAGE + bicycle.getRimFront().getDiameter() +
//                                TYRE_DIAMETER_MESSAGE + bicycle.getTyreFront().getDiameter()))
//                .build();
//    }
//
//    private CompatibilityResult frontWheelRimToTyreSizeCheck(Bicycle bicycle) {
//        boolean isCompatible = isRimToTyreWidthCompatible(
//                bicycle.getTyreFront().getWidth(),
//                bicycle.getRimFront().getInnerWidth());
//
//        return CompatibilityResult.builder()
//                .name("Front wheel rim and tyre width check")
//                .value(isCompatible)
//                .message(utils.printMessage(isCompatible, rimTyreMessage(bicycle.getRimFront().getInnerWidth())))
//                .build();
//    }
//
//    private CompatibilityResult frontWheelHolesCheck(Bicycle bicycle) {
//        boolean isCompatible = isFrontNumberOfHolesCompatible(bicycle);
//
//        return CompatibilityResult.builder()
//                .name("Front wheel number of holes check")
//                .value(isCompatible)
//                .message(utils.printMessage(isCompatible,
//                        NUMBER_OF_HOLES_RIM_MESSAGE + bicycle.getRimFront().getHoles() +
//                        NUMBER_OF_HOLES_HUB_MESSAGE + bicycle.getRimFront().getHoles()))
//                .build();
//    }
//
//    // FRONT WHEEL
//    //----------------------
//    // REAR WHEEL
//
//    private static Boolean isRearRimToTyreDiameterCompatible(Bicycle bicycle) {
//        return bicycle.getRimRear().getDiameter() == bicycle.getTyreRear().getDiameter();
//    }
//
//    private static Boolean isRearNumberOfHolesCompatible(Bicycle bicycle) {
//        return bicycle.getRimRear().getHoles() == bicycle.getHubRear().getHoles();
//    }
//
//    List<CompatibilityResult> rearWheelCheckTests(Bicycle bicycle) {
//        return List.of(
//                rearWheelDiameterCheck(bicycle),
//                rearWheelRimToTyreSizeCheck(bicycle),
//                rearWheelHolesCheck(bicycle)
//        );
//    }
//
//    Boolean isRearWheelCompatible(Bicycle bicycle) {
//        return isRearRimToTyreDiameterCompatible(bicycle) && isRearNumberOfHolesCompatible(bicycle);
//    }
//
//    private CompatibilityResult rearWheelDiameterCheck(Bicycle bicycle) {
//        boolean isCompatible = isRearRimToTyreDiameterCompatible(bicycle);
//
//        return CompatibilityResult.builder()
//                .name("Rear wheel rim and tyre diameter check")
//                .value(isCompatible)
//                .message(utils.printMessage(isCompatible,
//                        RIM_DIAMETER_MESSAGE + bicycle.getRimRear().getDiameter() +
//                        TYRE_DIAMETER_MESSAGE + bicycle.getRimRear().getDiameter()))
//                .build();
//    }
//
//    private CompatibilityResult rearWheelRimToTyreSizeCheck(Bicycle bicycle) {
//        boolean isCompatible = isRimToTyreWidthCompatible(
//                bicycle.getTyreFront().getWidth(),
//                bicycle.getRimFront().getInnerWidth());
//
//        return CompatibilityResult.builder()
//                .name("Rear wheel rim and tyre width check")
//                .value(isCompatible)
//                .message(utils.printMessage(isCompatible, rimTyreMessage(bicycle.getRimRear().getInnerWidth())))
//                .build();
//    }
//
//    private CompatibilityResult rearWheelHolesCheck(Bicycle bicycle) {
//        boolean isCompatible = isRearNumberOfHolesCompatible(bicycle);
//
//        return CompatibilityResult.builder()
//                .name("Rear wheel number of holes check")
//                .value(isCompatible)
//                .message(utils.printMessage(isCompatible,
//                        NUMBER_OF_HOLES_RIM_MESSAGE + bicycle.getRimRear().getHoles() +
//                        NUMBER_OF_HOLES_HUB_MESSAGE + bicycle.getHubRear().getHoles()))
//                .build();
//    }
//
//    // Utilities
//
//    private static Boolean isRimToTyreWidthCompatible(int tyreWidth, double rimWidth) {
//        int tyre = tyreWidth;
//        List<Integer> rangeList = tyreRimRange(rimWidth);
//        int min = rangeList.get(0);
//        int max = rangeList.get(1);
//        return (tyre >= min && tyre <= max);
//    }
//
//    public static List<Integer> tyreRimRange(double rimWidth) {
//        double rim = rimWidth;
//        double temp = 0;
//        for (double key : DIAMETERS_MAP.keySet()) {
//            if (rim == key) {
//                temp = key;
//            }
//        }
//        return DIAMETERS_MAP.get(temp);
//
//    }
//
//    private static final Map<Double, List<Integer>> DIAMETERS_MAP = Collections.unmodifiableMap(Map.ofEntries(
//            Map.entry(13.0, List.of(18, 25)),
//            Map.entry(15.0, List.of(23, 32)),
//            Map.entry(17.0, List.of(25, 52)),
//            Map.entry(19.0, List.of(28, 62)),
//            Map.entry(20.0, List.of(28, 62)),
//            Map.entry(21.0, List.of(35, 62)),
//            Map.entry(23.0, List.of(37, 62)),
//            Map.entry(25.0, List.of(42, 62)),
//            Map.entry(29.0, List.of(47, 62)),
//            Map.entry(30.0, List.of(52, 62)),
//            Map.entry(35.0, List.of(60, 75)),
//            Map.entry(40.0, List.of(65, 75)),
//            Map.entry(45.0, List.of(70, 75))
//    ));
//
//    private static final String NUMBER_OF_HOLES_RIM_MESSAGE = ": number of holes in your rim equals ";
//    private static final String NUMBER_OF_HOLES_HUB_MESSAGE = " and number of holes in your hub equals ";
//
//    private static final String RIM_DIAMETER_MESSAGE = ": your rim diameter equals ";
//    private static final String TYRE_DIAMETER_MESSAGE = " and your tyre diameter equals ";
//
//    private static String rimTyreMessage(double rimWidth) {
//        try {
//            return ": your rim width equals " + rimWidth +
//                    " mm and thus recommended size of a tyre is " +
//                    tyreRimRange(rimWidth).get(0) + " - " +
//                    tyreRimRange(rimWidth).get(1) + " mm";
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
