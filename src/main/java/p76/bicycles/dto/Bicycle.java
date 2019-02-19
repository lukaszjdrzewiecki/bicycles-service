package p76.bicycles.dto;
import lombok.Data;

import java.util.Arrays;

@Data
public class Bicycle {

    private String manufacturer;
    private String name;
    private Crank crank;
    private Casette casette;
    private FrontDerailleur frontDerailleur;
    private RearDerailleur rearDerailleur;
    private Brakes brakes;
    private Wheels wheels;
    private static int ID = 0;
    private final int numberID;

    public String toString()
    {
        return "Bicycle: " + manufacturer + " " + name + " [ID " + numberID + "]" +
                " with Parts: \n" +
                "[CRANK] " + this.crank +
                " [CASETTE] " + this.casette +
                " [FRONT DERAILLEUR] " + this.frontDerailleur +
                " [REAR DERAILLEUR] " + this.rearDerailleur +
                " [BRAKES] " + this.brakes +
                " [WHEELS] " + this.wheels;
    }

    public Bicycle() {
        ID++;
        this.numberID = ID;
    }

    public Bicycle(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
        ID++;
        this.numberID = ID;
    }

}
