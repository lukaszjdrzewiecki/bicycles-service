package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.wheels.FrontWheel;
import p76.bicycles.db.entity.wheels.RearWheel;

import java.util.ArrayList;
import java.util.List;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class CompatibilityWheelService {

    @Autowired
    DataService dataService;

    @Autowired
    CompatibilityService compatibilityService;

    @Autowired
    Messages messages;

    public List<CompatibilityResult> frontWheelCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        FrontWheel frontWheel = bicycle.getFrontWheel();
        frontWheelChecks(result, frontWheel);
        return result;
    }

    public List<CompatibilityResult> rearWheelCheckTests(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList<>();
        RearWheel rearWheel = bicycle.getRearWheel();
        rearWheelChecks(result, rearWheel);
        return result;
    }

    private void frontWheelChecks(List<CompatibilityResult> result, FrontWheel frontWheel) {
        result.add(new CompatibilityResult("DIAMETER" + CHECK, wheelDiameterCheck(frontWheel), messages.printMessage(wheelDiameterCheck(frontWheel), wheelDiameterMessage(frontWheel))));
        result.add(new CompatibilityResult("RIM AND TYRE SIZES" + CHECK, rimTyreCompatibilityCheck(frontWheel), messages.printMessage(rimTyreCompatibilityCheck(frontWheel), messages.rimTyreMessage(frontWheel))));
        result.add(new CompatibilityResult("SPOKE HOLES" + CHECK, wheelHolesCheck((frontWheel)), messages.printMessage(wheelHolesCheck(frontWheel), wheelHolesMessage(frontWheel))));
    }

    Boolean wheelDiameterCheck(FrontWheel frontWheel) {
        try {
            if (dataService.allEqual(frontWheel.getRim().getDiameter(), frontWheel.getTyre().getDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean wheelHolesCheck(FrontWheel frontWheel) {
        try {
            if (dataService.allEqual(frontWheel.getRim().getHoles(), frontWheel.getFrontHub().getHoles())) {
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

    Boolean rimTyreCompatibilityCheck(FrontWheel frontWheel) {
        try {
            int tyre = frontWheel.getTyre().getWidth();
            List<Integer> rangeList = tyreRimRange(frontWheel);
            int min = rangeList.get(0);
            int max = rangeList.get(1);
            boolean flag = (tyre >= min && tyre <= max);
            return flag;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Integer> tyreRimRange(FrontWheel frontWheel) {
        try {
            double rim = frontWheel.getRim().getInnerWidth();
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


    // FRONT WHEEL
    //----------------------
    // REAR WHEEL


    private void rearWheelChecks(List<CompatibilityResult> result, RearWheel rearWheel) {
        result.add(new CompatibilityResult("DIAMETER" + CHECK, wheelDiameterCheck(rearWheel), messages.printMessage(wheelDiameterCheck(rearWheel), wheelDiameterMessage(rearWheel))));
        result.add(new CompatibilityResult("RIM AND TYRE SIZES" + CHECK, rimTyreCompatibilityCheck(rearWheel), messages.printMessage(rimTyreCompatibilityCheck(rearWheel), messages.rimTyreMessage(rearWheel))));
        result.add(new CompatibilityResult("SPOKE HOLES" + CHECK, wheelHolesCheck((rearWheel)), messages.printMessage(wheelHolesCheck(rearWheel), wheelHolesMessage(rearWheel))));
    }

    Boolean wheelDiameterCheck(RearWheel rearWheel) {
        try {
            if (dataService.allEqual(rearWheel.getRim().getDiameter(), rearWheel.getTyre().getDiameter())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return null;
        }
    }

    Boolean wheelHolesCheck(RearWheel rearWheel) {
        try {
            if (dataService.allEqual(rearWheel.getRim().getHoles(), rearWheel.getRearHub().getHoles())) {
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

    Boolean rimTyreCompatibilityCheck(RearWheel rearWheel) {
        try {
            int tyre = rearWheel.getTyre().getWidth();
            List<Integer> rangeList = tyreRimRange(rearWheel);
            int min = rangeList.get(0);
            int max = rangeList.get(1);
            boolean flag = (tyre >= min && tyre <= max);
            return flag;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Integer> tyreRimRange(RearWheel rearWheel) {
        try {
            double rim = rearWheel.getRim().getInnerWidth();
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



}
