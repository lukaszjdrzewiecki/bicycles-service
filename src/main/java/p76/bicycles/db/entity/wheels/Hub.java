package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Hub extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int holes;
    private int width;
    private String axleDiameters;
    private String axleType;
    private String discType;
    private double flangeDiameterLeft;
    private double flangeDistanceRight;
    private double offset;
    private double pcdLeft;
    private double pcdRight;

    public Hub(String name, String brand, String productClass, String purpose, double weight, int holes, int width, String axleDiameters, String axleType, String discType, double flangeDiameterLeft, double flangeDistanceRight, double offset, double pcdLeft, double pcdRight) {
        super(name, brand, productClass, purpose, weight);
        this.holes = holes;
        this.width = width;
        this.axleDiameters = axleDiameters;
        this.axleType = axleType;
        this.discType = discType;
        this.flangeDiameterLeft = flangeDiameterLeft;
        this.flangeDistanceRight = flangeDistanceRight;
        this.offset = offset;
        this.pcdLeft = pcdLeft;
        this.pcdRight = pcdRight;
    }

    public Hub(String name, String brand, String productClass, String purpose, double weight, int holes, int width, String axleDiameters, String axleType, String discType) {
        super(name, brand, productClass, purpose, weight);
        this.holes = holes;
        this.width = width;
        this.axleDiameters = axleDiameters;
        this.axleType = axleType;
        this.discType = discType;
    }
}
