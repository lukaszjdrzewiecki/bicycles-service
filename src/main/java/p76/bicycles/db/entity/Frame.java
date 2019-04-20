package p76.bicycles.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Frame extends BicyclePart{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double topHeadSetDiameter;
    private double bottomHeadSetDiameter;
    private int bottomBracketLength;
    private int bottomBracketSize;
    private boolean pressFit;
    private boolean threaded;
    private boolean italianThread;
    private int rearWheelWidth;
    private int rearWheelAxleSize;
    private double seatpostSize;
    private String discBrakeMount;
    private String brakeType;
    private Boolean tapered;

    public Frame(String brand, String name, double weight, double topHeadSetDiameter, double bottomHeadSetDiameter, int bottomBracketLength, int bottomBracketSize, boolean pressFit, boolean threaded, boolean italianThread, int rearWheelWidth, int rearWheelAxleSize, double seatpostSize, String discBrakeMount, String brakeType, Boolean tapered) {
        super(brand, name, weight);
        this.topHeadSetDiameter = topHeadSetDiameter;
        this.bottomHeadSetDiameter = bottomHeadSetDiameter;
        this.bottomBracketLength = bottomBracketLength;
        this.bottomBracketSize = bottomBracketSize;
        this.pressFit = pressFit;
        this.threaded = threaded;
        this.italianThread = italianThread;
        this.rearWheelWidth = rearWheelWidth;
        this.rearWheelAxleSize = rearWheelAxleSize;
        this.seatpostSize = seatpostSize;
        this.discBrakeMount = discBrakeMount;
        this.brakeType = brakeType;
        this.tapered = tapered;
    }
}
