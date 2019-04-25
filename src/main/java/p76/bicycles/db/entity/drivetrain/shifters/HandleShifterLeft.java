package p76.bicycles.db.entity.drivetrain.shifters;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.db.entity.brakes.BrakeHandleLeft;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class HandleShifterLeft extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    ShifterLeft shifterLeft;

    @ManyToOne(cascade = CascadeType.ALL)
    BrakeHandleLeft brakeHandleLeft;

    public HandleShifterLeft(String name, String brand, double weight, ShifterLeft shifterLeft, BrakeHandleLeft brakeHandleLeft) {
        super(name, brand, weight);
        this.shifterLeft = shifterLeft;
        this.brakeHandleLeft = brakeHandleLeft;
    }
}
