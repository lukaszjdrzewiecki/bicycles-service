package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Frame;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.CHECK;

@Component
public class FrameCompatibilityService {

    @Autowired
    DataService dataService;

    public List<CompatibilityResult> frameCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        frameChecks(result, bicycle);
        return result;
    }

    private void frameChecks(List<CompatibilityResult> result, Bicycle bicycle) {
        result.add(new CompatibilityResult("REAR HUB SPACE" + CHECK, rearHubWidthCheck(bicycle), "message"));
        result.add(new CompatibilityResult("HEADSET & FRAME DIAMETERS" + CHECK, frameHeadSetCheck(bicycle), "message"));
        result.add(new CompatibilityResult("FRAME & FORK & HEADSET" + CHECK, forkHeadSetCheck(bicycle), "message"));
        result.add(new CompatibilityResult("TAPER" + CHECK, forkTaperCheck(bicycle), "message"));
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
            if (dataService.allTrue(bicycle.getFrame().getTapered(), bicycle.getFork().getTapered(), bicycle.getHeadSet().getTapered()) && frameHeadSetCheck(bicycle)) {
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
