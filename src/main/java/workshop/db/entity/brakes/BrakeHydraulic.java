package workshop.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeHydraulic extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Mineral, DOT
    private String oilType;

    private String brakePads;

    //Front, Rear, Left, Right
    private String side;

    //SM-BH90-SBM, SM-BH90-SBLS
    private String hoseType;

}
