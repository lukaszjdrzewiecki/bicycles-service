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

    private String type;
    private int year;
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
    private double seatpostCaliperDiameter;
    private String discBrakeMount;
    private String brakeType;
    private Boolean tapered;

}
