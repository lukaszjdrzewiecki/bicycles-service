package p76.bicycles.db.entity.Drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.db.entity.Brakes.BrakeHandleRight;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class HandleShifterRight extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    ShifterRight shifterRight;

    @ManyToOne(cascade = CascadeType.ALL)
    BrakeHandleRight brakeHandleRight;

    public HandleShifterRight(String name, String brand, double weight, ShifterRight shifterRight, BrakeHandleRight brakeHandleRight) {
        super(name, brand, weight);
        this.shifterRight = shifterRight;
        this.brakeHandleRight = brakeHandleRight;
    }
}