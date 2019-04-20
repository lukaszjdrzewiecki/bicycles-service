package p76.bicycles.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Fork extends BicyclePart{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String year;
    private int travel;
    private double headTube;
    private double headTubeRadius;
    private Boolean tapered;
    private String leftChamber;
    private String rightChamber;
    private int axleWidth;
    private int axleRadius;
    private String stanchions;
    private String wheel;
    private String brake;

    public Fork(String name, String brand, double weight, String year, int travel, double headTube, double headTubeRadius, Boolean tapered, String leftChamber, String rightChamber, int axleWidth, int axleRadius, String stanchions, String wheel, String brake) {
        super(name, brand, weight);
        this.year = year;
        this.travel = travel;
        this.headTube = headTube;
        this.headTubeRadius = headTubeRadius;
        this.tapered = tapered;
        this.leftChamber = leftChamber;
        this.rightChamber = rightChamber;
        this.axleWidth = axleWidth;
        this.axleRadius = axleRadius;
        this.stanchions = stanchions;
        this.wheel = wheel;
        this.brake = brake;
    }
}
