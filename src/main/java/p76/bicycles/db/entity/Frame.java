package p76.bicycles.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.enums.ForkTubeType;

import javax.persistence.*;

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
    private String bottomBracketSize;
    private String bottomBracketType;
    private String rearWheelAxleSize;
    private double seatpostSize;
    private double seatpostCaliperDiameter;
    private String discBrakeMount;
    private String brakeType;

    @Enumerated(value = EnumType.STRING)
    private ForkTubeType forkTubeType;

    private String year;

}
