package p76.bicycles.service;

public class BicycleCompatibility {

    public int drivaterrainCapacity(int minCasette, int maxCasette, int minCrank, int maxCrank){
        return (maxCasette - minCasette) + (maxCasette - minCasette);
    }

    public boolean rearDerailleurCompability (int drivaterrainCapacity, int rearDerailleurCapacity){
        if (rearDerailleurCapacity >= drivaterrainCapacity){
            return true;
        }
        return false;
    }

}
