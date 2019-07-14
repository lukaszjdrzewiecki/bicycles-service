package p76.bicycles.db.entity.suspension;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Fork extends BicyclePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected double headTubeLength;
    protected double headTubeTopDiameter;
    protected double headTubeBottomDiameter;
    private String year;

    private String forkTubeType;

    protected String axleSize;
    private String material;
    protected String wheel;
    protected String brakeType;
    protected String discMount;

    //to suspensionFork
    private int travel;
    private String leftChamber;
    private String rightChamber;
    private String uppersSize;
    private Boolean remoteLockout;

}
