package p76.bicycles.service.compatibility;

import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

@Component
public class FrameCompatibilityService {

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
}
