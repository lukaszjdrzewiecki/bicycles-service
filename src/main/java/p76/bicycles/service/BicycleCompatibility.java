package p76.bicycles.service;

import p76.bicycles.dto.Bicycle;
import p76.bicycles.dto.Casette;

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

    boolean speedCheck(Bicycle bicycle) {
        if (allEqual(bicycle.getCasette().getSpeed(), bicycle.getRearDerailleur().getSpeed(), bicycle.getCrank().getSpeed())) {
            return true;
        }
        return false;
    }

    public void speedCheckPrint(Bicycle bicycle) {
        if (speedCheck(bicycle)) {
            System.out.println("[SPEED CHECK] : all components compatible");
        } else {
            System.out.println("[SPEED CHECK] : not compatible");
        }
    }

    boolean allEqual(int a, int... integers) {
        for (int i : integers) if (!(i == a)) return false;
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
        if(wheelDiameterCheck(bicycle)){
            System.out.println("[DIAMETER] : all components compatible");
        } else {
            System.out.println("[DIAMETER] : not compatible");
        }
        if(wheelHolesCheck(bicycle)){
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
        speedCheckPrint(bicycle);
        System.out.println("-------------------");
        wheelCheckPrint(bicycle);
    }


}
