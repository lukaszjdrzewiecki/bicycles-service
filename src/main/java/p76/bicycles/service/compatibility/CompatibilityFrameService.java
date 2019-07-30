package p76.bicycles.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompatibilityFrameService {

    private final DataService dataService;
    private final Messages messages;

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
        return dataService.allTrue(isHeadsetCompatible(bicycle), isTapered(bicycle));
    }

    private CompatibilityResult rearHubWithCheck(Bicycle bicycle) {
        boolean isCompatible = bicycle.getHubRear().getAxleDiameter()
                .equals(bicycle.getFrame().getRearWheelAxleSize());

        return CompatibilityResult.builder()
                .name("Rear hub space check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.rearHubWidthMessage(bicycle)))
                .build();
    }

    private CompatibilityResult frameHeadsetCheck(Bicycle bicycle) {
        boolean isCompatible = isFrameCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Headset & frame diameters")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.frameHeadSetMessage(bicycle)))
                .build();
    }

    private CompatibilityResult forkHeadSetCheck(Bicycle bicycle) {
        boolean isCompatible = isForkHeadsetCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Headset & frame diameters")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.forkHeadSetCheckMessage(bicycle)))
                .build();
    }

    private CompatibilityResult totalHeadSetCheck(Bicycle bicycle) {
        boolean isCompatible = isHeadsetCompatible(bicycle);

        return CompatibilityResult.builder()
                .name("Headset check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.totalHeadSetMessage(bicycle)))
                .build();
    }

    private CompatibilityResult forkTaperCheck(Bicycle bicycle) {
        boolean isCompatible = isTapered(bicycle);

        return CompatibilityResult.builder()
                .name("Tapered check")
                .value(isCompatible)
                .message(messages.printMessage(isCompatible, messages.forkTaperMessage(bicycle)))
                .build();
    }
}
