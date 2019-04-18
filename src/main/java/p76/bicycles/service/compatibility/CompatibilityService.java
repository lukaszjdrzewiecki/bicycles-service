package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Wheel;
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
    SpeedsCompatibilityService speedsCompatibilityService;

    @Autowired
    FrameCompatibilityService frameCompatibilityService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> bicycleCheck(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList();
        result.add(new CompatibilityResult("drivetrainCheck", drivetrainCompatibilityService.drivetrainCheck(bicycle), "test"));
        result.add(new CompatibilityResult("speedsCompatibilityCheck", speedsCompatibilityService.speedsCompatibilityCheck(bicycle), "test"));
        result.add(new CompatibilityResult(FRONT_WHEEL + CHECK, wheelCompatibilityService.frontWheelCheck(bicycle), messages.compatibilityMessage(wheelCompatibilityService.frontWheelCheck(bicycle)), wheelCompatibilityService.frontWheelCheckFull(bicycle)));
        result.add(new CompatibilityResult(REAR_WHEEL + CHECK, wheelCompatibilityService.rearWheelCheck(bicycle), messages.compatibilityMessage(wheelCompatibilityService.rearWheelCheck(bicycle)), wheelCompatibilityService.rearWheelCheckFull(bicycle)));
        result.add(new CompatibilityResult("rearHubWidthCheck", frameCompatibilityService.rearHubWidthCheck(bicycle), "test"));
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
