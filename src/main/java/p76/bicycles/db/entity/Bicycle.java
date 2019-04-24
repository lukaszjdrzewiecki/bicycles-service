package p76.bicycles.db.entity;
import lombok.Data;
import p76.bicycles.db.entity.Brakes.BrakeHandleLeft;
import p76.bicycles.db.entity.Brakes.BrakeHandleRight;
import p76.bicycles.db.entity.Drivetrain.Cassette;
import p76.bicycles.db.entity.Drivetrain.Crank;
import p76.bicycles.db.entity.Drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.Drivetrain.RearDerailleur;
import p76.bicycles.db.entity.Drivetrain.Shifters.ShifterRight;
import p76.bicycles.db.entity.Drivetrain.Shifters.ShifterLeft;
import p76.bicycles.db.entity.Seatpost.Saddle;
import p76.bicycles.db.entity.Seatpost.SeatPostClamp;
import p76.bicycles.db.entity.Seatpost.Seatpost;
import p76.bicycles.db.entity.Steering.Grips;
import p76.bicycles.db.entity.Steering.Handlebar;
import p76.bicycles.db.entity.Steering.Stem;
import p76.bicycles.db.entity.Suspension.Fork;
import p76.bicycles.db.entity.Steering.HeadSet;
import p76.bicycles.db.entity.Wheels.FrontWheel;
import p76.bicycles.db.entity.Wheels.RearWheel;

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

    // ------ Brakes -------
    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeHandleRight brakeHandleRight;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeHandleLeft brakeHandleLeft;
    // ------ Brakes -------

    // ------- Drivetrain --------
    @ManyToOne(cascade = CascadeType.ALL)
    private Crank crank;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cassette cassette;

    @ManyToOne(cascade = CascadeType.ALL)
    private FrontDerailleur frontDerailleur;

    @ManyToOne(cascade = CascadeType.ALL)
    private RearDerailleur rearDerailleur;

    @ManyToOne(cascade = CascadeType.ALL)
    private ShifterLeft shifterLeft;

    @ManyToOne(cascade = CascadeType.ALL)
    private ShifterRight shifterRight;
    // ------- Drivetrain --------

    //--------- Seatpost ------------
    @ManyToOne(cascade = CascadeType.ALL)
    private Seatpost seatpost;

    @ManyToOne(cascade = CascadeType.ALL)
    private Saddle saddle;

    @ManyToOne(cascade = CascadeType.ALL)
    private SeatPostClamp seatPostClamp;
    //--------- Seatpost ------------

    // -------- Steering ---------
    @ManyToOne(cascade = CascadeType.ALL)
    private HeadSet headSet;

    @ManyToOne(cascade = CascadeType.ALL)
    private Handlebar handlebar;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stem stem;

    @ManyToOne(cascade = CascadeType.ALL)
    private Grips grips;
    // -------- Steering ---------

    // --------- Suspension ---------
    @ManyToOne(cascade = CascadeType.ALL)
    private Fork fork;
    // --------- Suspension ---------

    //---------- Wheels ----------
    @ManyToOne(cascade = CascadeType.ALL)
    private FrontWheel frontWheel;

    @ManyToOne(cascade = CascadeType.ALL)
    private RearWheel rearWheel;
    //---------- Wheels ----------


    @ManyToOne(cascade = CascadeType.ALL)
    private Frame frame;

    public String toString()
    {
        return "Bicycle: " + manufacturer + " " + name + " [ID " + id  + "]" +
                " with Parts: \n" +
                "[CRANK] " + this.crank +
                " [CASETTE] " + this.cassette +
                " [FRONT DERAILLEUR] " + this.frontDerailleur +
                " [REAR DERAILLEUR] " + this.rearDerailleur +
                " [FRONT WHEEL] " + this.frontWheel +
                " [REAR WHEEL] " + this.rearWheel;
    }

}
