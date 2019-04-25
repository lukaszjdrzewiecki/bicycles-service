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
public class Cassette extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int minimum;
    private int maximum;
    private int speeds;

    public Cassette(String name) {
        super(name);
    }

    public Cassette(String name, String brand, double weight, int minimum, int maximum, int speeds) {
        super(name, brand, weight);
        this.minimum = minimum;
        this.maximum = maximum;
        this.speeds = speeds;
    }
}