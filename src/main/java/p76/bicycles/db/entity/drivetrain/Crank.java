package p76.bicycles.db.entity.drivetrain;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Crank extends BicyclePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String defaultChainrings;
    private String defaultChainringsId;
    private int pcdBig;
    private int pcdSmall;
    private String armsAndType;
    private String armLength;
    private int numberOfGears;
    private int speeds;
    private int qfactor;
    private double chainline;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring bigGear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring mediumGear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chainring smallGear;

}
