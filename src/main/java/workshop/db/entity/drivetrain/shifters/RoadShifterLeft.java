package workshop.db.entity.drivetrain.shifters;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RoadShifterLeft extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int gears;

    //Cable, Hydraulic
    private String brakeType;

}
