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
    private FrontWheel frontWheel;
    private RearWheel rearWheel;
    private long id;



    public String toString()
    {
        return "Bicycle: " + manufacturer + " " + name + " [ID " + id  + "]" +
                " with Parts: \n" +
                "[CRANK] " + this.crank +
                " [CASETTE] " + this.casette +
                " [FRONT DERAILLEUR] " + this.frontDerailleur +
                " [REAR DERAILLEUR] " + this.rearDerailleur +
                " [BRAKES] " + this.brakes +
                " [FRONT WHEEL] " + this.frontWheel +
                " [REAR WHEEL] " + this.rearWheel;
    }

    public Bicycle() {
        this.id = 0;
    }

    public Bicycle(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.id = 0;
    }

    public String fullName(){
        return this.manufacturer + " " + this.name + " [ID " + this.id + "]";
    }

}
