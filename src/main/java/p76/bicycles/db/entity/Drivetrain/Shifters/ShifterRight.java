package p76.bicycles.db.entity.Drivetrain.Shifters;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ShifterRight extends Shifter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ShifterRight(String name, String brand, double weight, int speeds, String series) {
        super(name, brand, weight, speeds, series);
    }

    public ShifterRight(int speeds, String series) {
        super(speeds, series);
    }
}
