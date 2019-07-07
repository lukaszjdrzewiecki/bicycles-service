package p76.bicycles.db.entity.drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Crank extends BicyclePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String defaultChainrings;
    private String defaultChainringsId;

    //integrated or cartridge
    //private String brakeType;

    //usually 96 or 104
    private int pcdBig;

    //i.e. 96, 104. Distance in mm from one hole in arm to hole in opposite arm
    private int pcdSmall;

    //4 - MTB, 5 - Road. Arms can be symmetric or asymmetric. Type without arms - DIRECT MOUNT
    private String armsAndType;

    //165, 170, 172.5, 175
    private String armLength;

    //1, 2, 3
    private int numberOfGears;
    private int speeds;
    private int qfactor;
    private double chainline;

    //only in integrated systems
    private double axleDiameter;

    //private String cartridgeType

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring bigGear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring mediumGear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring smallGear;

    @Column
    private String bigGearInfo;
}
