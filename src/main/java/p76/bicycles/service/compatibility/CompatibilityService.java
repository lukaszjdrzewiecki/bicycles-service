package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.service.BicycleService;
import java.util.*;
import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class CompatibilityService {

    @Autowired
    BicycleRepository repository;

    @Autowired
    BicycleService service;

    @Autowired
    DataService dataService;

    @Autowired
    WheelCompatibilityService wheelCompatibilityService;

    @Autowired
    DrivetrainCompatibilityService drivetrainCompatibilityService;
    
    @Autowired
    FrameCompatibilityService frameCompatibilityService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> bicycleCheck(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList();
        result.add(new CompatibilityResult(DRIVETRAIN + CHECK, drivetrainCompatibilityService.drivetrainCapacityCheck(bicycle), "test", drivetrainCompatibilityService.drivetrainCheckTests(bicycle)));
        result.add(new CompatibilityResult(FRONT_WHEEL + CHECK, wheelCompatibilityService.frontWheelCheck(bicycle), messages.printMessage(wheelCompatibilityService.frontWheelCheck(bicycle)), wheelCompatibilityService.frontWheelCheckTests(bicycle)));
        result.add(new CompatibilityResult(REAR_WHEEL + CHECK, wheelCompatibilityService.rearWheelCheck(bicycle), messages.printMessage(wheelCompatibilityService.rearWheelCheck(bicycle)), wheelCompatibilityService.rearWheelCheckTests(bicycle)));
        result.add(new CompatibilityResult(FRAME + CHECK, frameCompatibilityService.totalFrameCheck(bicycle), "All must be true", frameCompatibilityService.frameCheckTests(bicycle)));
        return result;
    }

    public List<List<CompatibilityResult>> bicycleCheckAll() {
        List<List<CompatibilityResult>> result = new ArrayList<>();

        List<Bicycle> bicycles = service.findAllBicycles();
        for (Bicycle bicycle : bicycles) {
            result.add(bicycleCheck(bicycle));
        }

        return result;
    }

}
