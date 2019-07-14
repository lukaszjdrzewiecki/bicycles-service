package p76.bicycles.db.entity.drivetrain;

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
public class Cassette extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //smallest cog - usually 10 or 11 teeth
    private int smallest;

    //biggest cog - i.e. 42
    private int biggest;

    private int speeds;

    //Shimano, Sram, Campagnolo
    private String freewheelBody;

}