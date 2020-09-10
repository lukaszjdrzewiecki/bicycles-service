package workshop.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class HeadSet extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double stereerDiameter;
    private double topFrameDiameter;
    private double bottomFrameDiameter;
    private double topHeadTubeDiameter;
    private double bottomHeadTubeDiameter;

    //a-head, semi-integrated, integrated
    private String type;

    //Regular, Tapered
    private String forkTubeType;

}
