package p76.bicycles.db.entity.drivetrain;

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
public class FrontDerailleur {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String productId;
    private String product;
    private String brand;
    private String name;
    private String series;
    private String purpose;
    private double weight;
    private String comment;

    private int maxBigGear;
    private int minBigGear;
    private int capacity;
    private int gears;
    private int speeds;
    private String cableRouteType;
    private int gearMaxDifference;
    private String cage;
    private String mount;
    private double chainLine;
    private String chainstayAngle;

}
