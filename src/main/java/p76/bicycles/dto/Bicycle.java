package p76.bicycles.dto;
import lombok.Data;

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
    private final long ID;



    public String toString()
    {
        return "Bicycle: " + manufacturer + " " + name + " [ID " + ID  + "]" +
                " with Parts: \n" +
                "[CRANK] " + this.crank +
                " [CASETTE] " + this.casette +
                " [FRONT DERAILLEUR] " + this.frontDerailleur +
                " [REAR DERAILLEUR] " + this.rearDerailleur +
                " [BRAKES] " + this.brakes +
                " [WHEELS] " + this.wheels;
    }

    public Bicycle() {
        numberID id = new numberID();
        this.ID = id.createID();

    }

    public Bicycle(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
        numberID id = new numberID();
        this.ID = id.createID();

    }


}
