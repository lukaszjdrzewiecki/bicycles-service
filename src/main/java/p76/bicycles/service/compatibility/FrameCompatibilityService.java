package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.CHECK;

@Component
public class FrameCompatibilityService {

    @Autowired
    DataService dataService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> frameCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        frameChecks(result, bicycle);
        return result;
    }

    private void frameChecks(List<CompatibilityResult> result, Bicycle bicycle) {
        result.add(new CompatibilityResult("REAR HUB SPACE" + CHECK, rearHubWidthCheck(bicycle), messages.printMessage(rearHubWidthCheck(bicycle), messages.rearHubWidthMessage(bicycle))));
        result.add(new CompatibilityResult("HEADSET & FRAME DIAMETERS" + CHECK, frameHeadSetCheck(bicycle), messages.printMessage(frameHeadSetCheck(bicycle), messages.frameHeadSetMessage(bicycle))));
        result.add(new CompatibilityResult("HEADSET & FORK DIAMETERS" + CHECK, forkHeadSetCheck(bicycle), messages.printMessage(forkHeadSetCheck(bicycle), messages.forkHeadSetCheckMessage(bicycle))));
        result.add(new CompatibilityResult("TOTAL HEADSET" + CHECK, totalHeadSetCheck(bicycle), messages.printMessage(totalHeadSetCheck(bicycle), messages.totalHeadSetMessage(bicycle))));
        result.add(new CompatibilityResult("TAPER" + CHECK, forkTaperCheck(bicycle), messages.printMessage(forkTaperCheck(bicycle), messages.forkTaperMessage(bicycle))));
    }

    public Boolean rearHubWidthCheck(Bicycle bicycle) {
        try {
            if (bicycle.getRearWheel().getHub().getWidth() == bicycle.getFrame().getRearWheelWidth()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean totalFrameCheck(Bicycle bicycle) {
        try {
        return dataService.allTrue(totalHeadSetCheck(bicycle), forkTaperCheck(bicycle));
        } catch (Exception e) {
            return null;
        }
    }


    public Boolean frameHeadSetCheck(Bicycle bicycle) {
        try {
            if ((bicycle.getFrame().getTopHeadSetDiameter() == bicycle.getHeadSet().getTopFrameDiameter()) &&
                    (bicycle.getFrame().getBottomHeadSetDiameter() == bicycle.getHeadSet().getBottomFrameDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean forkHeadSetCheck(Bicycle bicycle) {
        try {
            if ((bicycle.getHeadSet().getTopHeadTubeDiameter() == bicycle.getFork().getHeadTubeTopDiameter()) &&
                    (bicycle.getHeadSet().getBottomHeadTubeDiameter() == bicycle.getFork().getHeadTubeBottomDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean totalHeadSetCheck(Bicycle bicycle) {
        try {
            if (forkHeadSetCheck(bicycle) && frameHeadSetCheck(bicycle)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean forkTaperCheck(Bicycle bicycle) {
        try {
            if (bicycle.getFrame().getTapered() && bicycle.getFork().getTapered()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }
}
