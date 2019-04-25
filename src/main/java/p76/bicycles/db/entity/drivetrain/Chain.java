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
public class Chain extends BicyclePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String series;
    private String material;
    private int speeds;

    public Chain(String name, String brand, double weight, String series, String material, int speeds) {
        super(name, brand, weight);
        this.series = series;
        this.material = material;
        this.speeds = speeds;
    }
}