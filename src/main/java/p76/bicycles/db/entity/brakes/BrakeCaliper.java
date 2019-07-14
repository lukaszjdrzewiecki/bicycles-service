package p76.bicycles.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeCaliper extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //DISC, ROAD, V-BRAKE
    private String brakeCaliperType;

}
