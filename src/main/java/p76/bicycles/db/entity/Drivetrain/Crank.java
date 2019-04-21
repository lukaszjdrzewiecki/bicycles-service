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
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    public Crank(String name, String brand, double weight, int pcdBig, int pcdSmall, String armsAndType, int armLength, int numberOfGears, int speed, Chainring mediumGear, Chainring smallGear) {
        super(name, brand, weight);
        this.pcdBig = pcdBig;
        this.pcdSmall = pcdSmall;
        this.armsAndType = armsAndType;
        this.armLength = armLength;
        this.numberOfGears = numberOfGears;
        this.mediumGear = mediumGear;
        this.smallGear = smallGear;
        this.speed = speed;
    }

    public Crank(String name, String brand, double weight, int pcdBig, String armsAndType, int armLength, int numberOfGears, int speed, Chainring mediumGear) {
        super(name, brand, weight);
        this.pcdBig = pcdBig;
        this.armsAndType = armsAndType;
        this.armLength = armLength;
        this.numberOfGears = numberOfGears;
        this.mediumGear = mediumGear;
        this.speed = speed;
    }
}
