package p76.bicycles.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.enums.ForkTubeType;
import p76.bicycles.enums.InsertType;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class HeadSet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String productId;
    private String product;
    private String brand;
    private String name;
    private String series;
    private String purpose;
    private double weight;
    private String comment;

    private double stereerDiameter;
    private double topFrameDiameter;
    private double bottomFrameDiameter;
    private double topHeadTubeDiameter;
    private double bottomHeadTubeDiameter;

    @Enumerated(value = EnumType.STRING)
    private ForkTubeType forkTubeType;

    @Enumerated(value = EnumType.STRING)
    private InsertType insertType;

}
