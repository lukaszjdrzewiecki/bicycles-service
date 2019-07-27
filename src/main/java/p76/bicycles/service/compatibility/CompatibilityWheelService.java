package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class CompatibilityWheelService {

    @Autowired
    DataService dataService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> frontWheelCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        frontWheelChecks(result, bicycle);
        return result;
    }

    public List<CompatibilityResult> rearWheelCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        rearWheelChecks(result, bicycle);
        return result;
    }

    private void frontWheelChecks(List<CompatibilityResult> result, Bicycle bicycle) {
        result.add(new CompatibilityResult("DIAMETER" + CHECK, wheelDiameterCheckFront(bicycle), messages.printMessage(wheelDiameterCheckFront(bicycle), wheelDiameterMessageFront(bicycle))));
        result.add(new CompatibilityResult("RIM AND TYRE SIZES" + CHECK, rimTyreCompatibilityCheckFront(bicycle), messages.printMessage(rimTyreCompatibilityCheckFront(bicycle), messages.rimTyreMessageFront(bicycle))));
        result.add(new CompatibilityResult("SPOKE HOLES" + CHECK, wheelHolesCheckFront((bicycle)), messages.printMessage(wheelHolesCheckFront(bicycle), wheelHolesMessageFront(bicycle))));
    }

    Boolean wheelDiameterCheckFront(Bicycle bicycle) {
        try {
            if (dataService.allEqual(bicycle.getRimFront().getDiameter(), bicycle.getTyreFront().getDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean wheelHolesCheckFront(Bicycle bicycle) {
        try {
            if (dataService.allEqual(bicycle.getRimFront().getHoles(), bicycle.getHubFront().getHoles())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }


    Boolean rimTyreCompatibilityCheckFront(Bicycle bicycle) {
        try {
            int tyre = bicycle.getTyreFront().getWidth();
            List<Integer> rangeList = tyreRimRangeFront(bicycle);
            int min = rangeList.get(0);
            int max = rangeList.get(1);
            boolean flag = (tyre >= min && tyre <= max);
            return flag;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Integer> tyreRimRangeFront(Bicycle bicycle) {
        try {
            double rim = bicycle.getRimFront().getInnerWidth();
            double temp = 0;
            for (double key : dataService.diameterMap().keySet()) {
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

    public Boolean frontWheelCheck(Bicycle bicycle) {
        try {
            if (wheelDiameterCheckFront(bicycle) && wheelHolesCheckFront(bicycle)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    // FRONT WHEEL
    //----------------------
    // REAR WHEEL


    private void rearWheelChecks(List<CompatibilityResult> result, Bicycle bicycle) {
        result.add(new CompatibilityResult("DIAMETER" + CHECK, wheelDiameterCheckRear(bicycle), messages.printMessage(wheelDiameterCheckRear(bicycle), wheelDiameterMessageRear(bicycle))));
        result.add(new CompatibilityResult("RIM AND TYRE SIZES" + CHECK, rimTyreCompatibilityCheckRear(bicycle), messages.printMessage(rimTyreCompatibilityCheckRear(bicycle), messages.rimTyreMessageRear(bicycle))));
        result.add(new CompatibilityResult("SPOKE HOLES" + CHECK, wheelHolesCheckRear((bicycle)), messages.printMessage(wheelHolesCheckRear(bicycle), wheelHolesMessageRear(bicycle))));
    }

    Boolean wheelDiameterCheckRear(Bicycle bicycle) {
        try {
            if (dataService.allEqual(bicycle.getRimRear().getDiameter(), bicycle.getTyreRear().getDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean wheelHolesCheckRear(Bicycle bicycle) {
        try {
            if (dataService.allEqual(bicycle.getRimRear().getHoles(), bicycle.getHubRear().getHoles())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }


    Boolean rimTyreCompatibilityCheckRear(Bicycle bicycle) {
        try {
            int tyre = bicycle.getTyreRear().getWidth();
            List<Integer> rangeList = tyreRimRangeRear(bicycle);
            int min = rangeList.get(0);
            int max = rangeList.get(1);
            boolean flag = (tyre >= min && tyre <= max);
            return flag;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Integer> tyreRimRangeRear(Bicycle bicycle) {
        try {
            double rim = bicycle.getRimRear().getInnerWidth();
            double temp = 0;
            for (double key : dataService.diameterMap().keySet()) {
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

    public Boolean rearWheelCheck(Bicycle bicycle) {
        try {
            if (wheelDiameterCheckRear(bicycle) && wheelHolesCheckRear(bicycle)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

}
