package p76.bicycles.service;

import p76.bicycles.dto.Bicycle;
import p76.bicycles.dto.Casette;
import p76.bicycles.dto.FrontWheel;

import java.util.*;

public class BicycleCompatibility {

    private int drivetrainCapacity(Bicycle bicycle) {
        return (bicycle.getCasette().getMaximum() - bicycle.getCasette().getMinimum())
                + (bicycle.getCrank().getBigGear() - bicycle.getCrank().getSmallGear());
    }

    public boolean drivetrainCheck(Bicycle bicycle) {
        if (bicycle.getRearDerailleur().getCapacity() >= drivetrainCapacity(bicycle)) {
            return true;
        }
        return false;
    }

    public void drivetrainCheckPrint(Bicycle bicycle) {
        if (drivetrainCheck(bicycle)) {
            System.out.println("[DRIVETRAIN CHECK] : all components compatible");
        } else {
            System.out.println("[DRIVETRAIN CHECK] : not compatible");
            System.out.println("[DRIVETRAIN CHECK] : " + "Biggest possible gear of the casette in this bicycle is " + (bicycle.getRearDerailleur().getCapacity() - drivetrainCapacity(bicycle) + bicycle.getCasette().getMaximum()));
        }
    }

    public void changeCasette(Bicycle bicycle, Casette casette) {
        System.out.println("[CHANGING CASETTE]");
        bicycle.setCasette(casette);
        drivetrainCheckPrint(bicycle);
    }

    boolean speedsCompatibilityCheck(Bicycle bicycle) {
        if (allEqual(bicycle.getCasette().getSpeed(), bicycle.getRearDerailleur().getSpeed(), bicycle.getCrank().getSpeed())) {
            return true;
        }
        return false;
    }

    public void speedsCompatibilityCheckPrint(Bicycle bicycle) {
        if (speedsCompatibilityCheck(bicycle)) {
            System.out.println("[SPEED CHECK] : all components compatible");
        } else {
            System.out.println("[SPEED CHECK] : not compatible");
        }
    }

    boolean allEqual(int a, int... integers) {
        for (int i : integers) {
            if (!(i == a)) {
                return false;
            }
        }
        return true;
    }

    public boolean wheelDiameterCheck(Bicycle bicycle) {
        if (allEqual(bicycle.getFrontWheel().getRim().getDiameter(), bicycle.getFrontWheel().getTyre().getDiameter())) {
            return true;
        }
        return false;
    }

    public boolean wheelHolesCheck(Bicycle bicycle) {
        if (allEqual(bicycle.getFrontWheel().getRim().getHoles(), bicycle.getFrontWheel().getHub().getHoles())) {
            return true;
        }
        return false;
    }

    public void wheelCheckPrint(Bicycle bicycle) {
        System.out.println("[WHEEL CHECK]");
        if (wheelDiameterCheck(bicycle)) {
            System.out.println("[DIAMETER] : all components compatible");
        } else {
            System.out.println("[DIAMETER] : not compatible");
        }
        if (wheelHolesCheck(bicycle)) {
            System.out.println("[NUMBER OF HOLES] : all components compatible");
        } else {
            System.out.println("[NUMBER OF HOLES] : not compatible. RIM: " + bicycle.getFrontWheel().getRim().getHoles() + ", HUB: " + bicycle.getFrontWheel().getHub().getHoles());
        }
    }

    public void bicycleCheck(Bicycle bicycle) {
        System.out.println("[GENERAL COMPATIBILITY CHECK] " + bicycle.fullName());
        System.out.println("-------------------");
        drivetrainCheckPrint(bicycle);
        System.out.println("-------------------");
        speedsCompatibilityCheckPrint(bicycle);
        System.out.println("-------------------");
        rimTyreComatibilityCheckPrint(bicycle);
        System.out.println("-------------------");
        wheelCheckPrint(bicycle);
    }

    public void rimTyreComatibilityCheckPrint(Bicycle bicycle) {
        int min = tyreRimRange(bicycle.getFrontWheel()).get(0);
        int max = tyreRimRange(bicycle.getFrontWheel()).get(1);
        if (rimTyreCompatibilityCheck(bicycle.getFrontWheel())) {
            System.out.println("[RIM & TYRE WIDTH CHECK : compatible");
        } else {
            System.out.println("[RIM & TYRE WIDTH CHECK] : not compatible. Your rim width equals " + bicycle.getFrontWheel().getRim().getInnerWidth() + " mm and thus recommended size of a tyre is " + min + " - " + max + " mm");
        }
    }

    public boolean rimTyreCompatibilityCheck(FrontWheel wheel) {
        int tyre = wheel.getTyre().getWidth();
        List<Integer> rangeList = tyreRimRange(wheel);
        int min = rangeList.get(0);
        int max = rangeList.get(1);
        boolean flag = (tyre >= min && tyre <= max);
        return flag;
    }

    public List<Integer> tyreRimRange(FrontWheel wheel) {
        int rim = wheel.getRim().getInnerWidth();
        int temp = 0;
        for (int key : diameterMap().keySet()) {
            if (rim == key) {
                temp = key;
            }
        }
        List<Integer> tempList = diameterMap().get(temp);
        return tempList;
    }

    private Map<Integer, List<Integer>> diameterMap() {
        Map<Integer, List<Integer>> diameters = new HashMap<>();
        diameters.put(13, new ArrayList<>(Arrays.asList(18, 25)));
        diameters.put(15, new ArrayList<>(Arrays.asList(23, 32)));
        diameters.put(17, new ArrayList<>(Arrays.asList(25, 52)));
        diameters.put(19, new ArrayList<>(Arrays.asList(28, 62)));
        diameters.put(21, new ArrayList<>(Arrays.asList(35, 62)));
        diameters.put(23, new ArrayList<>(Arrays.asList(37, 62)));
        diameters.put(25, new ArrayList<>(Arrays.asList(42, 62)));
        diameters.put(29, new ArrayList<>(Arrays.asList(47, 62)));
        diameters.put(30, new ArrayList<>(Arrays.asList(52, 62)));
        diameters.put(35, new ArrayList<>(Arrays.asList(60, 75)));
        diameters.put(40, new ArrayList<>(Arrays.asList(65, 75)));
        diameters.put(45, new ArrayList<>(Arrays.asList(70, 75)));
        return diameters;
    }
}
