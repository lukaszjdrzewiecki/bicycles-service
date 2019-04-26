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
public class RearDerailleur extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String maxFrontDifferenceGear;
    private int minLowGearCassette;
    private int maxLowGearCassette;
    private int maxGears; //maxGears // maxGears
    private int speeds;
    private String cage;
    private int capacity;

    public RearDerailleur(String name) {
        super(name);
    }

    public RearDerailleur(String name, String brand, double weight, int minLowGearCassette, int maxLowGearCassette, int maxGears, int speeds, String cage, int capacity) {
        super(name, brand, weight);
        this.minLowGearCassette = minLowGearCassette;
        this.maxLowGearCassette = maxLowGearCassette;
        this.maxGears = maxGears;
        this.speeds = speeds;
        this.cage = cage;
        this.capacity = capacity;
    }

    public RearDerailleur(String name, String brand, String productClass, String purpose, double weight, String maxFrontDifferenceGear, int minLowGearCassette, int maxLowGearCassette, int maxGears, int speeds, String cage, int capacity) {
        super(name, brand, productClass, purpose, weight);
        this.maxFrontDifferenceGear = maxFrontDifferenceGear;
        this.minLowGearCassette = minLowGearCassette;
        this.maxLowGearCassette = maxLowGearCassette;
        this.maxGears = maxGears;
        this.speeds = speeds;
        this.cage = cage;
        this.capacity = capacity;
    }
}
