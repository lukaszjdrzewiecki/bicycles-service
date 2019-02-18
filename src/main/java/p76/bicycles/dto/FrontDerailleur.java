package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FrontDerailleur extends BicyclePart {
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