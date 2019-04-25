package p76.bicycles.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BrakeHandle extends BicyclePart {

    private boolean hydraulic;
    private boolean road;
    private boolean mountain;
    private String oil;

    public BrakeHandle(String name, String brand, double weight, boolean hydraulic, boolean road, boolean mountain, String oil) {
        super(name, brand, weight);
        this.hydraulic = hydraulic;
        this.road = road;
        this.mountain = mountain;
        this.oil = oil;
    }
}
