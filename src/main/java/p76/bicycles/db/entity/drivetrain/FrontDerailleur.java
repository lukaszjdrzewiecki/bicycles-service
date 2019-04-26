package p76.bicycles.db.entity.drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class FrontDerailleur extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int maxBigGear;
    private int minBigGear;
    private int capacity;
    private int gears;
    private int speeds;
    private String cableRouteType;
    private int gearMaxDifference;
    private String cage;
    private String mount;
    private double chainLine;
    private String chainstayAngle;

    public FrontDerailleur(String name) {
        super(name);
    }

    public FrontDerailleur(String name, String brand, double weight, int maxBigGear, int minBigGear, int capacity, int gears, int speeds) {
        super(name, brand, weight);
        this.maxBigGear = maxBigGear;
        this.minBigGear = minBigGear;
        this.capacity = capacity;
        this.gears = gears;
        this.speeds = speeds;
    }

    public FrontDerailleur(String name, String brand, String productClass, String purpose, double weight, int maxBigGear, int minBigGear, int capacity, int gears, int speeds, String cableRouteType, int gearMaxDifference, String cage, String mount, double chainLine, String chainstayAngle) {
        super(name, brand, productClass, purpose, weight);
        this.maxBigGear = maxBigGear;
        this.minBigGear = minBigGear;
        this.capacity = capacity;
        this.gears = gears;
        this.speeds = speeds;
        this.cableRouteType = cableRouteType;
        this.gearMaxDifference = gearMaxDifference;
        this.cage = cage;
        this.mount = mount;
        this.chainLine = chainLine;
        this.chainstayAngle = chainstayAngle;
    }
}
