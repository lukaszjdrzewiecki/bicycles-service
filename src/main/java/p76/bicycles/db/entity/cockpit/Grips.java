package p76.bicycles.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.enums.GripType;
import p76.bicycles.enums.Side;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Grips extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Regular Grips, Road Tape
    private String gripType;

}
