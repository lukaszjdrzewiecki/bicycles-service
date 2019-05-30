package p76.bicycles.db.entity;
import lombok.Data;
import p76.bicycles.db.entity.brakes.BrakeHydraulic;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.db.entity.drivetrain.bottomBracket.BottomBracketIntegrated;
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
import p76.bicycles.db.entity.wheels.*;

import javax.persistence.*;

@Entity
@Data
public class Bicycle {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    // ------ brakes -------
    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeHydraulic brakeHydraulicFront;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeHydraulic brakeHydraulicRear;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Chain chain;

    @ManyToOne(cascade = CascadeType.ALL)
    private BottomBracketIntegrated bottomBracketIntegrated;
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
    private Tyre tyreFront;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disc discFront;

    @ManyToOne(cascade = CascadeType.ALL)
    private Rim rimFront;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hub hubFront;
    //--Front--
    //--Rear--
    @ManyToOne(cascade = CascadeType.ALL)
    private Rim rimRear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disc discRear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hub hubRear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tyre tyreRear;
    //---------- wheels ----------

    //----------- frame -----------
    @ManyToOne(cascade = CascadeType.ALL)
    private Frame frame;
    //----------- frame -----------




    // ------ brakes -------
    @Column
    private String brakeFrontInfo;

    @Column
    private String brakeRearInfo;
    // ------ brakes -------

    // ------- drivetrain --------
    @Column
    private String frontDerailleurInfo;

    @Column
    private String rearDerailleurInfo;

    @Column
    private String cassetteInfo;

    @Column
    private String chainInfo;

    @Column
    private String crankInfo;

    @Column
    private String shifterLeftInfo;

    @Column
    private String shifterRightInfo;

    @Column
    private String bottomBracketIntegratedInfo;
    // ------- drivetrain --------

    //--------- seatpost ------------
    @Column
    private String seatpostInfo;

    @Column
    private String seatpostClampInfo;

    @Column
    private String saddleInfo;
    //--------- seatpost ------------

    // -------- cockpit ---------
    @Column
    private String handlebarInfo;

    @Column
    private String stemInfo;

    @Column
    private String gripsInfo;

    @Column
    private String headSetInfo;
    // -------- cockpit ---------

    // --------- suspension ---------
    @Column
    private String forkInfo;
    // --------- suspension ---------

    //---------- wheels ----------
    @Column
    private String tyreFrontInfo;

    @Column
    private String discFrontInfo;

    @Column
    private String rimFrontInfo;

    @Column
    private String hubFrontInfo;
    //--Front--
    //--Rear--
    @Column
    private String rimRearInfo;

    @Column
    private String discRearInfo;

    @Column
    private String hubRearInfo;

    @Column
    private String tyreRearInfo;
    //---------- wheels ----------

    //----------- frame -----------
    @Column
    private String frameInfo;
    //----------- frame -----------



}
