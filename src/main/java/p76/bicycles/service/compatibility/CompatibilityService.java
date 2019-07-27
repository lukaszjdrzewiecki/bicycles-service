package p76.bicycles.service.compatibility;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.service.BicycleService;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Builder
@Component
public class CompatibilityService {

    @Autowired
    BicycleRepository repository;

    @Autowired
    BicycleService service;

    @Autowired
    DataService dataService;

    @Autowired
    CompatibilityWheelService compatibilityWheelService;

    @Autowired
    CompatibilityDrivetrainService compatibilityDrivetrainService;

    @Autowired
    CompatibilityFrameService compatibilityFrameService;

    @Autowired
    Messages messages;

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
        return compatibilityWheelService.frontWheelCheck(bicycle);
    }

    private boolean isRearWheelCompatible(Bicycle bicycle) {
        return compatibilityWheelService.rearWheelCheck(bicycle);
    }

    private boolean isDrivetrainCompatible(Bicycle bicycle) {
        return compatibilityDrivetrainService.drivetrainCapacityCheck(bicycle);
    }

    private boolean isFrameCompatible(Bicycle bicycle) {
        return compatibilityFrameService.totalFrameCheck(bicycle);
    }
}
