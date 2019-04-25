package p76.bicycles.db.entity.seatpost;

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
public class SeatPostClamp extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double setapostDiameter;
    private double frameDiameter;

    public SeatPostClamp(String name, String brand, double weight, double setapostDiameter, double frameDiameter) {
        super(name, brand, weight);
        this.setapostDiameter = setapostDiameter;
        this.frameDiameter = frameDiameter;
    }
}
