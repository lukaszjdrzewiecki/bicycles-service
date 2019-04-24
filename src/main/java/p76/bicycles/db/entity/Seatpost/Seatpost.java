package p76.bicycles.db.entity.Seatpost;

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
public class Seatpost extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double length;
    private double diameter;
    private String material;
    private boolean suspension;

    public Seatpost(String name, String brand, double weight, double length, double diameter, String material) {
        super(name, brand, weight);
        this.length = length;
        this.diameter = diameter;
        this.material = material;
    }

    public Seatpost(String name, String brand, double weight, double length, double diameter, String material, boolean suspension) {
        super(name, brand, weight);
        this.length = length;
        this.diameter = diameter;
        this.material = material;
        this.suspension = suspension;
    }
}
