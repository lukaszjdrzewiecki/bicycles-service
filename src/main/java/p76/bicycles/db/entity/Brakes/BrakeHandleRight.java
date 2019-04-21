package p76.bicycles.db.entity.Brakes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class BrakeHandleRight extends BrakeHandle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public BrakeHandleRight(String name, String brand, double weight, boolean hydraulic, boolean road, boolean mountain, String oil) {
        super(name, brand, weight, hydraulic, road, mountain, oil);
    }
}
