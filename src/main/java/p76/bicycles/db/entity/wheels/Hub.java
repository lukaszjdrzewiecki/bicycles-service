package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Data
@NoArgsConstructor
public abstract class Hub extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    protected int holes;
    protected int width;
    protected String axleDiameters;
    protected String axleType;
    protected String discType;
    protected double flangeDiameterLeft;
    protected double flangeDistanceRight;
    protected double offset;
    protected double pcdLeft;
    protected double pcdRight;

}
