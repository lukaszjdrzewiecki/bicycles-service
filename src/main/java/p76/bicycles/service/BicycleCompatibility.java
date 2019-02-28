package p76.bicycles.service;

import p76.bicycles.dto.Bicycle;
import p76.bicycles.dto.Casette;

public class BicycleCompatibility {


    private int drivetrainCapacity(Bicycle bicycle){
        return (bicycle.getCasette().getMaximum() - bicycle.getCasette().getMinimum())
                + (bicycle.getCrank().getBigGear() - bicycle.getCrank().getSmallGear());
    }

    public void drivetrainCheck(Bicycle bicycle){
        if (bicycle.getRearDerailleur().getCapacity() >= drivetrainCapacity(bicycle)){
            System.out.println("[DRIVETRAIN CHECK] : " + "Drivetrain of " + bicycle.FullName() + " is now compatible");

        } else {
            System.out.println("[DRIVETRAIN CHECK] : " + "Drivetrain of " + bicycle.FullName() + " is now not compatible");
            System.out.println("[DRIVETRAIN CHECK] : " + "Biggest gear of casette that is acceptable in your bicycle is " + (bicycle.getRearDerailleur().getCapacity() - drivetrainCapacity(bicycle) + bicycle.getCasette().getMaximum()));
        }

    }

    public void changeCasette(Bicycle bicycle, Casette casette){
        System.out.println("[CHANGING CASETTE]");
        bicycle.setCasette(casette);
        drivetrainCheck(bicycle);
    }

    public void speedCheck (Bicycle bicycle){
        if (allEqual(bicycle.getCasette().getSpeed(), bicycle.getRearDerailleur().getSpeed() , bicycle.getCrank().getSpeed())){
            System.out.println("[SPEED CHECK] : " + bicycle.FullName() + " has all the components designed for the same number of gears");
        } else {
            System.out.println("[SPEED CHECK] : " + bicycle.FullName() + " has some components that are not compatible in the aspect of number of gears");
        }
    }

    boolean allEqual(int a, int... integers) {
        for(int i : integers) if(!(i == a)) return false;
        return true;
    }

}
