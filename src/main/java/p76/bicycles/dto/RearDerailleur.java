package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RearDerailleur extends BicyclePart {
    private int speed;
    private String cage;
    private int capacity;

    public RearDerailleur(String name) {
        super(name);
    }

    public RearDerailleur(String name, int speed, String cage, int capacity) {
        super(name);
        this.speed = speed;
        this.cage = cage;
        this.capacity = capacity;
    }
}
