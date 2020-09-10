package workshop.db.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.brakes.BrakeHydraulic;
import workshop.db.entity.drivetrain.BottomBracket;
import workshop.db.entity.drivetrain.shifters.ShifterRight;
import workshop.db.entity.drivetrain.shifters.ShifterLeft;
import workshop.db.entity.seatpost.Saddle;
import workshop.db.entity.seatpost.SeatpostClamp;
import workshop.db.entity.seatpost.Seatpost;
import workshop.db.entity.cockpit.Grips;
import workshop.db.entity.cockpit.Handlebar;
import workshop.db.entity.cockpit.Stem;
import workshop.db.entity.suspension.Fork;
import workshop.db.entity.cockpit.HeadSet;
import workshop.db.entity.drivetrain.Cassette;
import workshop.db.entity.drivetrain.Chain;
import workshop.db.entity.drivetrain.Crank;
import workshop.db.entity.drivetrain.FrontDerailleur;
import workshop.db.entity.drivetrain.RearDerailleur;
import workshop.enums.BicycleType;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bicycle {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private String brand;
    private String model;

    private BicycleType type;

    private Double predefinedWeight;
    private Double countedWeight;

    private long year;

    // ------ brakes -------
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brake_hydraulic_front_id")
    private BrakeHydraulic brakeHydraulicFront;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brake_hydraulic_rear_id")
    private BrakeHydraulic brakeHydraulicRear;
    // ------ brakes -------

    // ------- drivetrain --------
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crank_id")
    private Crank crank;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cassette_id")
    private Cassette cassette;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "front_derailleur_id")
    private FrontDerailleur frontDerailleur;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rear_derailleur_id")
    private RearDerailleur rearDerailleur;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shifter_left_id")
    private ShifterLeft shifterLeft;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shifter_right_id")
    private ShifterRight shifterRight;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chain_id")
    private Chain chain;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bottom_bracket_id")
    private BottomBracket bottomBracket;
    // ------- drivetrain --------

    //--------- seatpost ------------
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatpost_id")
    private Seatpost seatpost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saddle_id")
    private Saddle saddle;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_post_clamp_id")
    private SeatpostClamp seatPostClamp;
    //--------- seatpost ------------

    // -------- cockpit ---------
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_set_id")
    private HeadSet headSet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handlebar_id")
    private Handlebar handlebar;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stem_id")
    private Stem stem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grips_id")
    private Grips grips;
    // -------- cockpit ---------

    // --------- suspension ---------
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fork_id")
    private Fork fork;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "wheel_id")
//    private Wheel frontWheel;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "wheel_id")
//    private Wheel rearWheel;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frame_id")
    private Frame frame;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedals_id")
    private Pedals pedals;



}
