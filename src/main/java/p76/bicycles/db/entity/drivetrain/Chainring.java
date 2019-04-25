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
public class Chainring extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String type;
    private String armsAndType;
    private int pcd;
    private int teethNumber;
    private int speeds;

    public Chainring(String name, String brand, double weight, String type, String armsAndType, int pcd, int teethNumber, int speeds) {
        super(name, brand, weight);
        this.type = type;
        this.armsAndType = armsAndType;
        this.pcd = pcd;
        this.teethNumber = teethNumber;
        this.speeds = speeds;
    }
}
