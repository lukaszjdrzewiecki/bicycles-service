package p76.bicycles.db.entity.Drivetrain.Shifters;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Shifter extends BicyclePart {

    private int speeds;

    public Shifter(String name, String brand, double weight, int speeds) {
        super(name, brand, weight);
        this.speeds = speeds;
    }

    public Shifter(int speeds) {
        this.speeds = speeds;
    }
}
