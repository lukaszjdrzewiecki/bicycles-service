package p76.bicycles.db.entity.brakes;

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
public class BrakeCaliper extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private boolean disc;
    private boolean road;
    private boolean vBrake;

    public BrakeCaliper(String name, String brand, double weight, boolean disc, boolean road, boolean vBrake) {
        super(name, brand, weight);
        this.disc = disc;
        this.road = road;
        this.vBrake = vBrake;
    }
}
