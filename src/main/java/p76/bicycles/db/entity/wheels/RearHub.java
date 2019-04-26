package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class RearHub extends Hub{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int speeds;
    private double freeWheelWidth;

    public RearHub(String name, String brand, String productClass, String purpose, double weight, int holes, int width, String axleDiameters, String axleType, String discType, double flangeDiameterLeft, double flangeDistanceRight, double offset, double pcdLeft, double pcdRight, int speeds, double freeWheelWidth) {
        super(name, brand, productClass, purpose, weight, holes, width, axleDiameters, axleType, discType, flangeDiameterLeft, flangeDistanceRight, offset, pcdLeft, pcdRight);
        this.speeds = speeds;
        this.freeWheelWidth = freeWheelWidth;
    }

    public RearHub(String name, String brand, String productClass, String purpose, double weight, int holes, int width, String axleDiameters, String axleType, String discType, int speeds, double freeWheelWidth) {
        super(name, brand, productClass, purpose, weight, holes, width, axleDiameters, axleType, discType);
        this.speeds = speeds;
        this.freeWheelWidth = freeWheelWidth;
    }
}
