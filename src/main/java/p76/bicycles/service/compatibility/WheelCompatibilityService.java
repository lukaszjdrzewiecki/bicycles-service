package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Wheel;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class WheelCompatibilityService {

    @Autowired
    DataService dataService;

    @Autowired
    CompatibilityService compatibilityService;

    public List<CompatibilityResult> frontWheelCheckFull(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        Wheel wheel = bicycle.getFrontWheel();
        wheelChecks(result, wheel);
        return result;
    }

    public List<CompatibilityResult> rearWheelCheckFull(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        Wheel wheel = bicycle.getRearWheel();
        wheelChecks(result, wheel);
        return result;
    }

    private void wheelChecks(List<CompatibilityResult> result, Wheel wheel) {
        result.add(new CompatibilityResult("DIAMETER" + CHECK, wheelDiameterCheck(wheel), compatibilityDiameterMessage(wheelDiameterCheck(wheel), wheel)));
        result.add(new CompatibilityResult("RIM AND TYRE SIZES" + CHECK, rimTyreCompatibilityCheck(wheel), compatibilityRimTyreMessage(rimTyreCompatibilityCheck(wheel), wheel)));
        result.add(new CompatibilityResult("SPOKE HOLES" + CHECK, wheelHolesCheck((wheel)), compatibilityHolesMessage(wheelHolesCheck(wheel), wheel)));
    }


    Boolean wheelDiameterCheck(Wheel wheel) {
        try {
            if (dataService.allEqual(wheel.getRim().getDiameter(), wheel.getTyre().getDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean wheelHolesCheck(Wheel wheel) {
        try {
            if (dataService.allEqual(wheel.getRim().getHoles(), wheel.getHub().getHoles())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean frontWheelCheck(Bicycle bicycle) {
        try {
            if (wheelDiameterCheck(bicycle.getFrontWheel()) && wheelHolesCheck(bicycle.getFrontWheel())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean rearWheelCheck(Bicycle bicycle) {
        try {
            if (wheelDiameterCheck(bicycle.getRearWheel()) && wheelHolesCheck(bicycle.getRearWheel())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean rimTyreCompatibilityCheck(Wheel wheel) {
        try {
            int tyre = wheel.getTyre().getWidth();
            List<Integer> rangeList = tyreRimRange(wheel);
            int min = rangeList.get(0);
            int max = rangeList.get(1);
            boolean flag = (tyre >= min && tyre <= max);
            return flag;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Integer> tyreRimRange(Wheel wheel) {
        try {
            int rim = wheel.getRim().getInnerWidth();
            int temp = 0;
            for (int key : dataService.diameterMap().keySet()) {
                if (rim == key) {
                    temp = key;
                }
            }
            List<Integer> tempList = dataService.diameterMap().get(temp);
            return tempList;
        } catch (Exception e) {
            return null;
        }
    }

    private String compatibilityRimTyreMessage(Boolean compatible, Wheel wheel) {
        try {
            int min = tyreRimRange(wheel).get(0);
            int max = tyreRimRange(wheel).get(1);
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT +
                    ": your rim width equals " + wheel.getRim().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " + min + " - " + max + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    private String compatibilityDiameterMessage(Boolean compatible, Wheel wheel) {
        try {
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT +
                    ": your rim diameter equals " + wheel.getRim().getDiameter() +
                    " and your tyre diameter equals " + wheel.getTyre().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    private String compatibilityHolesMessage(Boolean compatible, Wheel wheel) {
        try {
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT +
                    ": number of holes in your rim equals " + wheel.getRim().getHoles() +
                    " and number of holes in your hub equals " + wheel.getHub().getHoles();
        } catch (Exception e) {
            return null;
        }
    }
}
