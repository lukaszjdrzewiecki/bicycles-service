package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class HeadSet extends BicyclePart{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double stereerDiameter;
    private double topFrameDiameter;
    private double bottomFrameDiameter;
    private double topHeadTubeDiameter;
    private double bottomHeadTubeDiameter;
    private Boolean tapered;
    private String type;

    public HeadSet(String name, String brand, double weight, double stereerDiameter, double topFrameDiameter, double bottomFrameDiameter, double topHeadTubeDiameter, double bottomHeadTubeDiameter, Boolean tapered, String type) {
        super(name, brand, weight);
        this.stereerDiameter = stereerDiameter;
        this.topFrameDiameter = topFrameDiameter;
        this.bottomFrameDiameter = bottomFrameDiameter;
        this.topHeadTubeDiameter = topHeadTubeDiameter;
        this.bottomHeadTubeDiameter = bottomHeadTubeDiameter;
        this.tapered = tapered;
        this.type = type;
    }
}
