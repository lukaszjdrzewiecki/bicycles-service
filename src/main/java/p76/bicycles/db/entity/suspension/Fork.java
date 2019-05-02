package p76.bicycles.db.entity.suspension;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Fork extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String year;
    private int travel;
    private double headTubeLength;
    private double headTubeTopDiameter;
    private double headTubeBottomDiameter;
    private Boolean tapered;
    private String leftChamber;
    private String rightChamber;
    private int axleWidth;
    private int axleRadius;
    private String stanchions;
    private String wheel;
    private String brake;

}
