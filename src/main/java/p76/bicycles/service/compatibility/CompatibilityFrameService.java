package p76.bicycles.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import p76.bicycles.db.dto.CompatibilityResult;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.utils.Utils;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompatibilityFrameService {

    private static final String HUB_WIDTH_MESSAGE = ": hub width ";
    private static final String FRAME_SPACE_MESSAGE = " frame space ";

    private static final String TOTAL_HEADSET_MESSAGE = ": must meet the requirements of every other headset test";

    private final Utils utils;

    private static Boolean isFrameHeadsetCompatible(Bicycle bicycle) {
        return (bicycle.getFrame().getTopHeadSetDiameter() == bicycle.getHeadSet().getTopFrameDiameter()) &&
                (bicycle.getFrame().getBottomHeadSetDiameter() == bicycle.getHeadSet().getBottomFrameDiameter());
    }

    private static Boolean isForkHeadsetCompatible(Bicycle bicycle) {
        return ((bicycle.getHeadSet().getTopHeadTubeDiameter() == bicycle.getFork().getHeadTubeTopDiameter()) &&
                (bicycle.getHeadSet().getBottomHeadTubeDiameter() == bicycle.getFork().getHeadTubeBottomDiameter()));
    }

    private static Boolean isHeadsetCompatible(Bicycle bicycle) {
        return isForkHeadsetCompatible(bicycle) & isFrameHeadsetCompatible(bicycle);
    }

    private static Boolean isTapered(Bicycle bicycle) {
        return bicycle.getFrame().getForkTubeType().equals(bicycle.getFork().getForkTubeType());
    }


    public List<CompatibilityResult> frameCheckTests(Bicycle bicycle) {
        return List.of(
                rearHubWithCheck(bicycle),
                frameHeadsetCheck(bicycle),
                forkHeadSetCheck(bicycle),
                totalHeadSetCheck(bicycle),
                forkTaperCheck(bicycle)
        );
    }

    Boolean isFrameCompatible(Bicycle bicycle) {
        return allTrue(isHeadsetCompatible(bicycle), isTapered(bicycle));
    }

    private boolean allTrue(Boolean... booleans) {
        return Arrays.stream(booleans).allMatch(val -> val);

    }

    private CompatibilityResult rearHubWithCheck(Bicycle bicycle) {
        boolean isCompatible = bicycle.getHubRear().getAxleDiameter()
                .equals(bicycle.getFrame().getRearWheelAxleSize());

        return CompatibilityResult.builder()
                .name("Rear hub space check")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible,
                        HUB_WIDTH_MESSAGE + bicycle.getHubRear().getAxleDiameter() +
                                FRAME_SPACE_MESSAGE + bicycle.getFrame().getRearWheelAxleSize()))
                .build();
    }

    private CompatibilityResult frameHeadsetCheck(Bicycle bicycle) {
        boolean isCompatible = isFrameCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Headset & frame diameters")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible, frameHeadSetMessage(bicycle)))
                .build();
    }

    private CompatibilityResult forkHeadSetCheck(Bicycle bicycle) {
        boolean isCompatible = isForkHeadsetCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Headset & frame diameters")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible, forkHeadSetCheckMessage(bicycle)))
                .build();
    }

    private CompatibilityResult totalHeadSetCheck(Bicycle bicycle) {
        boolean isCompatible = isHeadsetCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Headset check")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible, TOTAL_HEADSET_MESSAGE))
                .build();
    }

    private CompatibilityResult forkTaperCheck(Bicycle bicycle) {
        boolean isCompatible = isTapered(bicycle);

        return CompatibilityResult.builder()
                .name("Tapered check")
                .value(isCompatible)
                .message(utils.printMessage(isCompatible, forkTaperMessage(bicycle)))
                .build();
    }

    private static String forkHeadSetCheckMessage(Bicycle bicycle) {
        return ": headset inner top " + bicycle.getHeadSet().getTopHeadTubeDiameter() +
                " fork top " + bicycle.getFork().getHeadTubeTopDiameter() + " | " +
                " headset inner bottom " + bicycle.getHeadSet().getBottomHeadTubeDiameter() +
                " fork bottom " + bicycle.getFork().getHeadTubeBottomDiameter();
    }


    private static String frameHeadSetMessage(Bicycle bicycle) {
        return ": frame top " + bicycle.getFrame().getTopHeadSetDiameter() +
                " headset outer top " + bicycle.getHeadSet().getTopFrameDiameter() + " | " +
                "frame bottom " + (bicycle.getFrame().getBottomHeadSetDiameter() +
                " headset outer bottom " + bicycle.getHeadSet().getBottomFrameDiameter());
    }

    private static String forkTaperMessage(Bicycle bicycle) {
        return ": frame tapered " + bicycle.getFrame().getForkTubeType() +
                " | fork tapered " + bicycle.getFork().getForkTubeType();
    }
}
