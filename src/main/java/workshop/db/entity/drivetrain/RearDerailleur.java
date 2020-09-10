package workshop.db.entity.drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class RearDerailleur extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int minLowGearCassette;
    private int maxLowGearCassette;
    private int maxGears;
    private int speeds;

    //short, medium, long
    private String cage;
    private int capacity;

}
