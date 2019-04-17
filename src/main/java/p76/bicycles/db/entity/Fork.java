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
@AllArgsConstructor
public class Fork {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String brand;
    private String name;
    private String year;
    private int travel;
    private double headTube;
    private double headTubeRadius;
    private boolean tapered;
    private String leftChamber;
    private String rightChamber;
    private int axleWidth;
    private int axleRadius;
    private int stanchions;
    private String wheel;
    private String brake;
}
