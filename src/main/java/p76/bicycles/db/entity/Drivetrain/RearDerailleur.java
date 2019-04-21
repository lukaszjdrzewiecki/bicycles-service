package p76.bicycles.db.entity.Drivetrain;

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
public class RearDerailleur extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int speed;
    private String cage;
    private int capacity;

    public RearDerailleur(String name) {
        super(name);
    }

    public RearDerailleur(String name, int speed, String cage, int capacity) {
        super(name);
        this.speed = speed;
        this.cage = cage;
        this.capacity = capacity;
    }
}
