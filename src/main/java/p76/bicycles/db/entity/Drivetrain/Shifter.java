package p76.bicycles.db.entity.Drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Shifter extends BicyclePart {

    private int speeds;
    private String series;

    public Shifter(String name, String brand, double weight, int speeds, String series) {
        super(name, brand, weight);
        this.speeds = speeds;
        this.series = series;
    }

    public Shifter(int speeds, String series) {
        this.speeds = speeds;
        this.series = series;
    }
}
