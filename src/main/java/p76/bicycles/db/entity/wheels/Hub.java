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
    protected String axleDiameters;
    protected String axleType;
    protected String discType;
    protected int width;
    protected double offsetLeft;
    protected double offsetRight;
    protected double pcdLeft;
    protected double pcdRight;

}
