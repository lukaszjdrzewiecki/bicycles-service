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

    private int smallest;
    private int biggest;
    private int speeds;
    private String freewheelBody;

    public Cassette(String name) {
        super(name);
    }

    public Cassette(String name, String brand, double weight, int smallest, int biggest, int speeds) {
        super(name, brand, weight);
        this.smallest = smallest;
        this.biggest = biggest;
        this.speeds = speeds;
    }

    public Cassette(String name, String brand, String productClass, String purpose, double weight, int smallest, int biggest, int speeds, String freewheelBody) {
        super(name, brand, productClass, purpose, weight);
        this.smallest = smallest;
        this.biggest = biggest;
        this.speeds = speeds;
        this.freewheelBody = freewheelBody;
    }
}