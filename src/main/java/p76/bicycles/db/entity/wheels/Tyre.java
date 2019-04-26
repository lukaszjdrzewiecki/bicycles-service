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
public class Tyre extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int width;
    private boolean tubeless;
    private int diameter;

    public Tyre(String name, String brand, String productClass, String purpose, double weight, int width, boolean tubeless, int diameter) {
        super(name, brand, productClass, purpose, weight);
        this.width = width;
        this.tubeless = tubeless;
        this.diameter = diameter;
    }
}
