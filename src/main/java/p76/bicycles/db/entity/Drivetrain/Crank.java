package p76.bicycles.db.entity.Drivetrain;

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
    private int pcdBig;
    private int pcdSmall;
    private String armsAndType;
    private int armLength;
    private int numberOfGears;
    private int speed;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring bigGear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring mediumGear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring smallGear;


    public Crank(String name) {
        super(name);
    }

    // 3 GEARS
    public Crank(String name, String brand, double weight, int pcdBig, int pcdSmall, String armsAndType, int armLength, int numberOfGears, int speed, Chainring bigGear, Chainring mediumGear, Chainring smallGear) {
        super(name, brand, weight);
        this.pcdBig = pcdBig;
        this.pcdSmall = pcdSmall;
        this.armsAndType = armsAndType;
        this.armLength = armLength;
        this.numberOfGears = numberOfGears;
        this.bigGear = bigGear;
        this.mediumGear = mediumGear;
        this.smallGear = smallGear;
        this.speed = speed;
    }

    // 2 GEARS
    public Crank(String name, String brand, double weight, int pcdBig, int pcdSmall, String armsAndType, int armLength, int numberOfGears, int speed, Chainring bigGear, Chainring smallGear) {
        super(name, brand, weight);
        this.pcdBig = pcdBig;
        this.pcdSmall = pcdSmall;
        this.armsAndType = armsAndType;
        this.armLength = armLength;
        this.numberOfGears = numberOfGears;
        this.bigGear = bigGear;
        this.smallGear = smallGear;
        this.speed = speed;
    }

    // 1 GEAR
    public Crank(String name, String brand, double weight, int pcdBig, String armsAndType, int armLength, int numberOfGears, int speed, Chainring bigGear) {
        super(name, brand, weight);
        this.pcdBig = pcdBig;
        this.armsAndType = armsAndType;
        this.armLength = armLength;
        this.numberOfGears = numberOfGears;
        this.bigGear = bigGear;
        this.speed = speed;
    }
}
