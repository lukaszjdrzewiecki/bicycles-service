package p76.bicycles.service.compatibility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.repository.BicycleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CompatibilityService {

    private final BicycleRepository repository;
    private final CompatibilityWheelService compatibilityWheelService;
    private final CompatibilityDrivetrainService compatibilityDrivetrainService;
    private final CompatibilityFrameService compatibilityFrameService;

    public Map<String, Boolean> isBicycleCompatible(Long bicycleId) {
        Bicycle bicycle = repository.findById(bicycleId).orElseThrow(EntityNotFoundException::new);

        return Map.of(
                "Front Wheel", isFrontWheelCompatible(bicycle),
                "Rear Wheel", isRearWheelCompatible(bicycle),
                "Drivetrain", isDrivetrainCompatible(bicycle),
                "Frame", isFrameCompatible(bicycle));
    }

    public List<CompatibilityResult> frontWheelCheck(Long bicycleId) {
        Bicycle bicycle = repository.findById(bicycleId).orElseThrow(EntityNotFoundException::new);

        return compatibilityWheelService.frontWheelCheckTests(bicycle);
    }

    public List<CompatibilityResult> rearWheelCheck(Long bicycleId) {
        Bicycle bicycle = repository.findById(bicycleId).orElseThrow(EntityNotFoundException::new);

        return compatibilityWheelService.rearWheelCheckTests(bicycle);
    }

    public List<CompatibilityResult> drivetrainCheck(Long bicycleId) {
        Bicycle bicycle = repository.findById(bicycleId).orElseThrow(EntityNotFoundException::new);

        return compatibilityDrivetrainService.drivetrainCheckTests(bicycle);
    }

    public List<CompatibilityResult> frameCheck(Long bicycleId) {
        Bicycle bicycle = repository.findById(bicycleId).orElseThrow(EntityNotFoundException::new);

        return compatibilityFrameService.frameCheckTests(bicycle);
    }


    private boolean isFrontWheelCompatible(Bicycle bicycle) {
        return compatibilityWheelService.isFrontWheelCompatible(bicycle);
    }

    private boolean isRearWheelCompatible(Bicycle bicycle) {
        return compatibilityWheelService.isRearWheelCompatible(bicycle);
    }

    private boolean isDrivetrainCompatible(Bicycle bicycle) {
        return compatibilityDrivetrainService.isDrivetrainCapacityCompatible(bicycle);
    }

    private boolean isFrameCompatible(Bicycle bicycle) {
        return compatibilityFrameService.isFrameCompatible(bicycle);
    }
}
