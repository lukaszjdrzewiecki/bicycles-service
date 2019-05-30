package p76.bicycles.db.entity.drivetrain.shifters;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.db.entity.brakes.BrakeHydraulic;

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
    BrakeHydraulic brakeRear;

}