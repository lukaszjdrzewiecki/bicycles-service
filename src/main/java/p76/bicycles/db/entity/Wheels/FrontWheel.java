package p76.bicycles.db.entity.Wheels;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.Wheels.Hub;
import p76.bicycles.db.entity.Wheels.Rim;
import p76.bicycles.db.entity.Wheels.Tyre;
import p76.bicycles.db.entity.Wheels.Wheel;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FrontWheel extends Wheel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public FrontWheel(Rim rim, Hub hub, Tyre tyre) {
        super(rim, hub, tyre);
    }
}
