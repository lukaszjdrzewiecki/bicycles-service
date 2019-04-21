package p76.bicycles.db.entity.Handlebars;

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
public class Stem extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int length;
    private int angle;
    private double headtubeDiameter;
    private double handlebarDiameter;

    public Stem(String name, String brand, double weight, int length, int angle, double headtubeDiameter, double handlebarDiameter) {
        super(name, brand, weight);
        this.length = length;
        this.angle = angle;
        this.headtubeDiameter = headtubeDiameter;
        this.handlebarDiameter = handlebarDiameter;
    }
}
