package p76.bicycles.db.entity;
import lombok.Data;

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
    private Cassette cassette;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Frame frame;

    @ManyToOne(cascade = CascadeType.ALL)
    private HeadSet headSet;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fork fork;

    public String toString()
    {
        return "Bicycle: " + manufacturer + " " + name + " [ID " + id  + "]" +
                " with Parts: \n" +
                "[CRANK] " + this.crank +
                " [CASETTE] " + this.cassette +
                " [FRONT DERAILLEUR] " + this.frontDerailleur +
                " [REAR DERAILLEUR] " + this.rearDerailleur +
                " [BRAKES] " + this.brakes +
                " [FRONT WHEEL] " + this.frontWheel +
                " [REAR WHEEL] " + this.rearWheel;
    }

}
