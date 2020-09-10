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
public class Chainring extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Narrow-wide or Regular
    private String type;

    //4 - MTB, 5 - Road. Arms can be symmetric or asymmetric. Type without arms - DIRECT MOUNT
    private String armsAndType;

    //i.e. 96, 104. Distance in mm from one hole in arm to hole in opposite arm
    private int pcd;

    private int teethNumber;

    private int speeds;
}
