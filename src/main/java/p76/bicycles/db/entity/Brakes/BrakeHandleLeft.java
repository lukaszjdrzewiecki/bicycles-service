package p76.bicycles.db.entity.Brakes;

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
public class BrakeHandleLeft extends BrakeHandle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public BrakeHandleLeft(String name, String brand, double weight, boolean hydraulic, boolean road, boolean mountain, String oil) {
        super(name, brand, weight, hydraulic, road, mountain, oil);
    }
}
