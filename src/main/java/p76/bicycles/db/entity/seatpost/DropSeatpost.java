package p76.bicycles.db.entity.seatpost;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class DropSeatpost extends Seatpost{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int travel;
    private boolean innerCable;

    public DropSeatpost(String name, String brand, double weight, double length, double diameter, String material, int travel, boolean innerCable) {
        super(name, brand, weight, length, diameter, material);
        this.travel = travel;
        this.innerCable = innerCable;
    }
}
