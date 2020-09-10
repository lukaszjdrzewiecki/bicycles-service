package workshop.db.entity.drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class BottomBracket extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Integrated, Cartridge
    private String type;

    //Threaded(BSA), Press-fit
    private String insertType;

    //Integrated
    private String bottomBracketShellDiameter;
    private double axleDiameter;
    //Integrated

    //Cartridge
    private double axleLength;
    private double shellLength;
    //Cartridge

}
