package p76.bicycles.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.enums.Side;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeLever extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Front, Rear, Left, Right
    private String side;
}
