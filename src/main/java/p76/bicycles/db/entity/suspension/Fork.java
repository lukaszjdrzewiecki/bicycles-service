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
public class Fork {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String productId;
    private String product;
    private String brand;
    private String name;
    private String series;
    private String purpose;
    private double weight;
    private String comment;

    protected double headTubeLength;
    protected double headTubeTopDiameter;
    protected double headTubeBottomDiameter;
    private String year;
    protected Boolean tapered;
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
