package p76.bicycles.db.entity.wheels;

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
public class Rim extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private double height;
    private double innerWidth;
    private double outerWidth;
    private int holes;
    private String brakeType;
    private boolean tubeless;
    private int diameter;
    private int ERD;
    private String material;

    public Rim(String name, String brand, String productClass, String purpose, double weight, double height, double innerWidth, double outerWidth, int holes, String brakeType, boolean tubeless, int diameter, int ERD, String material) {
        super(name, brand, productClass, purpose, weight);
        this.height = height;
        this.innerWidth = innerWidth;
        this.outerWidth = outerWidth;
        this.holes = holes;
        this.brakeType = brakeType;
        this.tubeless = tubeless;
        this.diameter = diameter;
        this.ERD = ERD;
        this.material = material;
    }
}
