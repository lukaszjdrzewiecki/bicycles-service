package p76.bicycles.db.entity;
import lombok.Data;
import p76.bicycles.db.entity.brakes.BrakeHydraulic;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.db.entity.drivetrain.BottomBracket;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brake_hydraulic_front_id")
    private BrakeHydraulic brakeHydraulicFront;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brake_hydraulic_rear_id")
    private BrakeHydraulic brakeHydraulicRear;
    // ------ brakes -------

    // ------- drivetrain --------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crank_id")
    private Crank crank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cassette_id")
    private Cassette cassette;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "front_derailleur_id")
    private FrontDerailleur frontDerailleur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rear_derailleur_id")
    private RearDerailleur rearDerailleur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shifter_left_id")
    private ShifterLeft shifterLeft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shifter_right_id")
    private ShifterRight shifterRight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chain_id")
    private Chain chain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bottom_bracket_id")
    private BottomBracket bottomBracket;
    // ------- drivetrain --------

    //--------- seatpost ------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatpost_id")
    private Seatpost seatpost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saddle_id")
    private Saddle saddle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_post_clamp_id")
    private SeatpostClamp seatPostClamp;
    //--------- seatpost ------------

    // -------- cockpit ---------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_set_id")
    private HeadSet headSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handlebar_id")
    private Handlebar handlebar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stem_id")
    private Stem stem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grips_id")
    private Grips grips;
    // -------- cockpit ---------

    // --------- suspension ---------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fork_id")
    private Fork fork;

    // --------- suspension ---------

    //---------- wheels ----------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tyre_front_id")
    private Tyre tyreFront;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disc_front_id")
    private Disc discFront;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rim_front_id")
    private Rim rimFront;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hub_front_id")
    private Hub hubFront;
    //--Front--
    //--Rear--
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rim_rear_id")
    private Rim rimRear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disc_rear_id")
    private Disc discRear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hub_rear_id")
    private Hub hubRear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tyre_rear_id")
    private Tyre tyreRear;
    //---------- wheels ----------

    //----------- frame -----------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frame_id")
    private Frame frame;
    //----------- frame -----------

    //----------- frame -----------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedals_id")
    private Pedals pedals;
    //----------- frame -----------


    // ------ brakes -------
    private String brakeFrontInfo;

    private String brakeRearInfo;
    // ------ brakes -------

    // ------- drivetrain --------
    private String frontDerailleurInfo;

    private String rearDerailleurInfo;

    private String cassetteInfo;

    private String chainInfo;

    private String crankInfo;

    private String shifterLeftInfo;

    private String shifterRightInfo;

    private String bottomBracketIntegratedInfo;
    // ------- drivetrain --------

    //--------- seatpost ------------
    private String seatpostInfo;

    private String seatpostClampInfo;

    private String saddleInfo;
    //--------- seatpost ------------

    // -------- cockpit ---------
    private String handlebarInfo;

    private String stemInfo;

    private String gripsInfo;

    private String headSetInfo;
    // -------- cockpit ---------

    // --------- suspension ---------
    private String forkInfo;
    // --------- suspension ---------

    //---------- wheels ----------
    private String tyreFrontInfo;

    private String discFrontInfo;

    private String rimFrontInfo;

    private String hubFrontInfo;
    //--Front--
    //--Rear--
    private String rimRearInfo;

    private String discRearInfo;

    private String hubRearInfo;

    private String tyreRearInfo;
    //---------- wheels ----------

    //----------- frame -----------
    private String frameInfo;
    //----------- frame -----------

    //----------- pedals -----------
    private String pedalsInfo;
    //----------- pedals -----------


}
