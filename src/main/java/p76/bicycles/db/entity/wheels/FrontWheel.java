package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FrontWheel extends Wheel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public FrontWheel(Rim rim, FrontHub hub, Tyre tyre) {
        super(rim, hub, tyre);
    }
}
