package p76.bicycles.db.entity.Handlebar;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class HandlebarRoad extends Handlebar {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int drop;
    private int reach;

    public HandlebarRoad(String name, String brand, double weight, double diameter, int width, String material, int drop, int reach) {
        super(name, brand, weight, diameter, width, material);
        this.drop = drop;
        this.reach = reach;
    }

}
