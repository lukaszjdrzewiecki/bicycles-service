package p76.bicycles.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeHandleRight extends BrakeHandle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeCaliper brakeCaliper;

    public BrakeHandleRight(String name, String brand, double weight, boolean hydraulic, boolean road, boolean mountain, String oil, BrakeCaliper brakeCaliper) {
        super(name, brand, weight, hydraulic, road, mountain, oil);
        this.brakeCaliper = brakeCaliper;
    }
}
