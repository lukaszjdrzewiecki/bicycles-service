package p76.bicycles.db.entity.drivetrain.shifters;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ShifterLeft extends Shifter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ShifterLeft(String name, String brand, double weight, int gears) {
        super(name, brand, weight, gears);
    }

    public ShifterLeft(int gears) {
        super(gears);
    }
}