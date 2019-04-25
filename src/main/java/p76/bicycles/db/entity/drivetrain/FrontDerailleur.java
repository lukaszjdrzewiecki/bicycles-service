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
}
