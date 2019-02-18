package p76.bicycles.service;

import p76.bicycles.dto.Bicycle;

public class BicycleCompatibility {


    public int driveterrainCapacity(Bicycle bicycle){
        return (bicycle.getCasette().getMaximum() - bicycle.getCasette().getMinimum())
                + (bicycle.getCrank().getBigGear() - bicycle.getCrank().getSmallGear());
    }

    public void rearDerailleurCompability (Bicycle bicycle){
        if (bicycle.getRearDerailleur().getCapacity() >= driveterrainCapacity(bicycle)){
            System.out.println("is compatible");

        }

    }

}
