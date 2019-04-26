package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RearWheel extends Wheel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    public RearWheel(Rim rim, RearHub hub, Tyre tyre) {
        super(rim, hub, tyre);
    }
}
