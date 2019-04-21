package p76.bicycles.db.entity.Handlebar;

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
public class Handlebar extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double diameter;
    private int offset;
    private int width;
    private int rise;
    private String material;

    public Handlebar(String name, String brand, double weight, double diameter, int width, String material) {
        super(name, brand, weight);
        this.diameter = diameter;
        this.width = width;
        this.material = material;
    }

    public Handlebar(String name, String brand, double weight, double diameter, int offset, int width, int rise, String material) {
        super(name, brand, weight);
        this.diameter = diameter;
        this.offset = offset;
        this.width = width;
        this.rise = rise;
        this.material = material;
    }
}
