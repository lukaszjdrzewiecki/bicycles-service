package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Data
@NoArgsConstructor
public abstract class Hub extends BicyclePart {

    protected int holes;
    protected String axleDiameter;
    protected String axleType;
    protected String discType;
    protected double offsetLeft;
    protected double offsetRight;
    protected double pcdLeft;
    protected double pcdRight;

}
