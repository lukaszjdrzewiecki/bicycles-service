package p76.bicycles.db.entity.drivetrain.bottomBracket;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class BottomBracketCartridge extends BottomBracket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double totalLength;
    private double sheelLength;

    public BottomBracketCartridge(String name, String brand, double weight, String type, double totalLength, double sheelLength) {
        super(name, brand, weight, type);
        this.totalLength = totalLength;
        this.sheelLength = sheelLength;
    }
}
