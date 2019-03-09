package p76.bicycles.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Bicycle {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String manufacturer;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Crank crank;

    @ManyToOne(cascade = CascadeType.ALL)
    private Casette casette;

    @ManyToOne(cascade = CascadeType.ALL)
    private FrontDerailleur frontDerailleur;

    @ManyToOne(cascade = CascadeType.ALL)
    private RearDerailleur rearDerailleur;

    @ManyToOne(cascade = CascadeType.ALL)
    private Brakes brakes;

    @ManyToOne(cascade = CascadeType.ALL)
    private FrontWheel frontWheel;

    @ManyToOne(cascade = CascadeType.ALL)
    private RearWheel rearWheel;

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

}
