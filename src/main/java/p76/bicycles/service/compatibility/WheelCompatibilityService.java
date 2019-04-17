package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Wheel;

import java.util.List;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class WheelCompatibilityService {

    @Autowired
    DataService dataService;

    public boolean wheelDiameterCheck(Wheel wheel) {
        if (dataService.allEqual(wheel.getRim().getDiameter(), wheel.getTyre().getDiameter())) {
            return true;
        }
        return false;
    }

    public boolean wheelHolesCheck(Wheel wheel) {
        if (dataService.allEqual(wheel.getRim().getHoles(), wheel.getHub().getHoles())) {
            return true;
        }
        return false;
    }

    public Boolean frontWheelCheck (Bicycle bicycle) {
        try {
            if (wheelDiameterCheck(bicycle.getFrontWheel()) && wheelHolesCheck(bicycle.getFrontWheel())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean rearWheelCheck (Bicycle bicycle) {
        try {
            if (wheelDiameterCheck(bicycle.getRearWheel()) && wheelHolesCheck(bicycle.getRearWheel())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    /*
    public void wheelCheckPrint(Bicycle bicycle) {
        System.out.println(WHEEL_CHECK);
        if (wheelDiameterCheck(bicycle)) {
            System.out.println(DIAMETER + COMPATIBLE_ALL);
        } else {
            System.out.println(DIAMETER + COMPATIBLE_NOT);
        }
        if (wheelHolesCheck(bicycle)) {
            System.out.println(NUMBER_OF_HOLES + COMPATIBLE_ALL);
        } else {
            System.out.println(NUMBER_OF_HOLES + COMPATIBLE_NOT + ". RIM: " + bicycle.getFrontWheel().getRim().getHoles() + ", HUB: " + bicycle.getFrontWheel().getHub().getHoles());
        }
    }

*/
    public void rimTyreComatibilityCheckPrint(Bicycle bicycle) {
        int min = tyreRimRange(bicycle.getFrontWheel()).get(0);
        int max = tyreRimRange(bicycle.getFrontWheel()).get(1);
        if (rimTyreCompatibilityCheck(bicycle.getFrontWheel())) {
            System.out.println(RIM_TYRE_CHECK + COMPATIBLE_ALL);
        } else {
            System.out.println(RIM_TYRE_CHECK + COMPATIBLE_NOT + ". Your rim width equals " + bicycle.getFrontWheel().getRim().getInnerWidth() + " mm and thus recommended size of a tyre is " + min + " - " + max + " mm");
        }
    }

    public boolean rimTyreCompatibilityCheck(Wheel wheel) {
        int tyre = wheel.getTyre().getWidth();
        List<Integer> rangeList = tyreRimRange(wheel);
        int min = rangeList.get(0);
        int max = rangeList.get(1);
        boolean flag = (tyre >= min && tyre <= max);
        return flag;
    }

    public List<Integer> tyreRimRange(Wheel wheel) {
        int rim = wheel.getRim().getInnerWidth();
        int temp = 0;
        for (int key : dataService.diameterMap().keySet()) {
            if (rim == key) {
                temp = key;
            }
        }
        List<Integer> tempList = dataService.diameterMap().get(temp);
        return tempList;
    }
}
