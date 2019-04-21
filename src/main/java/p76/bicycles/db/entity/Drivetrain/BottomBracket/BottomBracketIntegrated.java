package p76.bicycles.db.entity.Drivetrain.BottomBracket;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class BottomBracketIntegrated extends BottomBracket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double bottomBracketShellDiameter;
    private double axleDiameter;

    public BottomBracketIntegrated(String name, String brand, double weight, String type, double bottomBracketShellDiameter, double axleDiameter) {
        super(name, brand, weight, type);
        this.bottomBracketShellDiameter = bottomBracketShellDiameter;
        this.axleDiameter = axleDiameter;
    }
}
