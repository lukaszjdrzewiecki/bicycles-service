package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class FrontDerailleur extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int maxGear;
    private int minGear;
    private int capacity;
    private int gears;
    private int speed;

    public FrontDerailleur(String name) {
        super(name);
    }

    public FrontDerailleur(String name, int maxGear, int minGear, int capacity, int gears, int speed) {
        super(name);
        this.maxGear = maxGear;
        this.minGear = minGear;
        this.capacity = capacity;
        this.gears = gears;
        this.speed = speed;
    }
}
