package workshop.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Handlebar extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //mountain
    private double diameter;
    private double offsetBack;
    private int width;
    private int rise;
    //mountain

    //road
    private int barDrop;
    private int barReach;
    //road

    //Carbon, Aluminium, Steel, Magnesium, Titanium
    private String material;

    //mountain, road, trekking
    private String partType;

}
