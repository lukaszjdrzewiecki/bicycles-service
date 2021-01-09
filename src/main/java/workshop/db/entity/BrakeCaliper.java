package workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeCaliper extends BicyclePart {

    //DISC, ROAD, V-BRAKE
    private String brakeCaliperType;

}
