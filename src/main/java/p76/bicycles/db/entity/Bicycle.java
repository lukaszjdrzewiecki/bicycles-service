package p76.bicycles.db.entity;
import lombok.Data;
import p76.bicycles.db.entity.brakes.BrakeFront;
import p76.bicycles.db.entity.brakes.BrakeRear;
import p76.bicycles.db.entity.drivetrain.Cassette;
import p76.bicycles.db.entity.drivetrain.Crank;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterLeft;
import p76.bicycles.db.entity.seatpost.Saddle;
import p76.bicycles.db.entity.seatpost.SeatpostClamp;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.cockpit.Grips;
import p76.bicycles.db.entity.cockpit.Handlebar;
import p76.bicycles.db.entity.cockpit.Stem;
import p76.bicycles.db.entity.suspension.Fork;
import p76.bicycles.db.entity.cockpit.HeadSet;
import p76.bicycles.db.entity.wheels.FrontWheel;
import p76.bicycles.db.entity.wheels.RearWheel;

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

    // ------ brakes -------
    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeFront brakeFront;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeRear brakeRear;
    // ------ brakes -------

    // ------- drivetrain --------
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
    // ------- drivetrain --------

    //--------- seatpost ------------
    @ManyToOne(cascade = CascadeType.ALL)
    private Seatpost seatpost;

    @ManyToOne(cascade = CascadeType.ALL)
    private Saddle saddle;

    @ManyToOne(cascade = CascadeType.ALL)
    private SeatpostClamp seatPostClamp;
    //--------- seatpost ------------

    // -------- cockpit ---------
    @ManyToOne(cascade = CascadeType.ALL)
    private HeadSet headSet;

    @ManyToOne(cascade = CascadeType.ALL)
    private Handlebar handlebar;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stem stem;

    @ManyToOne(cascade = CascadeType.ALL)
    private Grips grips;
    // -------- cockpit ---------

    // --------- suspension ---------
    @ManyToOne(cascade = CascadeType.ALL)
    private Fork fork;
    // --------- suspension ---------

    //---------- wheels ----------
    @ManyToOne(cascade = CascadeType.ALL)
    private FrontWheel frontWheel;

    @ManyToOne(cascade = CascadeType.ALL)
    private RearWheel rearWheel;
    //---------- wheels ----------

    //----------- frame -----------
    @ManyToOne(cascade = CascadeType.ALL)
    private Frame frame;
    //----------- frame -----------
}
