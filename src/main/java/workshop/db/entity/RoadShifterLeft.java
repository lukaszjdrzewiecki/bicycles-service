package workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RoadShifterLeft extends BicyclePart {


    private int gears;

    //Cable, Hydraulic
    private String brakeType;

}
