package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Frame {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String brand;
    private String name;
    private double upperHeadSet;
    private double lowerHeadSet;
    private double headTubeWidth;
    private double headLength;
    private int bottomBracketLength;
    private int bottomBracketSize;
    private boolean pressFit;
    private boolean threaded;
    private boolean italianThread;
    private int rearWheelWidth;
    private int rearWheelAxleSize;
    private int seatpostSize;
    private String discBrakeMount;
    private String brakeType;

    public Frame(String brand, String name, double upperHeadSet, double lowerHeadSet, double headTubeWidth, double headLength, int bottomBracketLength, int bottomBracketSize, boolean pressFit, boolean threaded, boolean italianThread, int rearWheelWidth, int rearWheelAxleSize, int seatpostSize, String discBrakeMount, String brakeType) {
        this.brand = brand;
        this.name = name;
        this.upperHeadSet = upperHeadSet;
        this.lowerHeadSet = lowerHeadSet;
        this.headTubeWidth = headTubeWidth;
        this.headLength = headLength;
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
    }
}
