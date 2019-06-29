package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Hub {

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

    private int holes;
    private String axleDiameter;
    private String axleType;
    private String discType;
    private double offsetLeft;
    private double offsetRight;
    private double pcdLeft;
    private double pcdRight;
    private String hubType;

    private int speeds;
    private double freewheelWidth;
    private String freewheelType;

}
