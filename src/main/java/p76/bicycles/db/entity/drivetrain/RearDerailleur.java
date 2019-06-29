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
public class RearDerailleur {

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

    private int minLowGearCassette;
    private int maxLowGearCassette;
    private int maxGears; //maxGears // maxGears
    private int speeds;
    private String cage;
    private int capacity;

}
