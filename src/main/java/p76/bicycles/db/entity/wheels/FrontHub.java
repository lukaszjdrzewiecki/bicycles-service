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
public class FrontHub extends Hub {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public FrontHub(String name, String brand, String productClass, String purpose, double weight, int holes, int width, String axleDiameters, String axleType, String discType, double flangeDiameterLeft, double flangeDistanceRight, double offset, double pcdLeft, double pcdRight) {
        super(name, brand, productClass, purpose, weight, holes, width, axleDiameters, axleType, discType, flangeDiameterLeft, flangeDistanceRight, offset, pcdLeft, pcdRight);
    }

    public FrontHub(String name, String brand, String productClass, String purpose, double weight, int holes, int width, String axleDiameters, String axleType, String discType) {
        super(name, brand, productClass, purpose, weight, holes, width, axleDiameters, axleType, discType);
    }
}
