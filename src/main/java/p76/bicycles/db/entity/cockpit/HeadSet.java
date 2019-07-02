package p76.bicycles.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.enums.ForkTubeType;
import p76.bicycles.enums.InsertType;

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

    //Regular, Tapered
    private String forkTubeType;

    //Threaded, Press-fit
    private String insertType;

}
