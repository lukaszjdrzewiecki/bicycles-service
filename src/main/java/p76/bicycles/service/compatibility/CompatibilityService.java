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
    CompatibilityWheelService compatibilityWheelService;

    @Autowired
    CompatibilityDrivetrainService compatibilityDrivetrainService;
    
    @Autowired
    CompatibilityFrameService compatibilityFrameService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> bicycleCheck(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList();
        result.add(new CompatibilityResult(DRIVETRAIN + CHECK, compatibilityDrivetrainService.drivetrainCapacityCheck(bicycle), "test", compatibilityDrivetrainService.drivetrainCheckTests(bicycle)));
        result.add(new CompatibilityResult(FRONT_WHEEL + CHECK, compatibilityWheelService.frontWheelCheck(bicycle), messages.printMessage(compatibilityWheelService.frontWheelCheck(bicycle)), compatibilityWheelService.frontWheelCheckTests(bicycle)));
        result.add(new CompatibilityResult(REAR_WHEEL + CHECK, compatibilityWheelService.rearWheelCheck(bicycle), messages.printMessage(compatibilityWheelService.rearWheelCheck(bicycle)), compatibilityWheelService.rearWheelCheckTests(bicycle)));
        result.add(new CompatibilityResult(FRAME + CHECK, compatibilityFrameService.totalFrameCheck(bicycle), "All must be true", compatibilityFrameService.frameCheckTests(bicycle)));
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
