package workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Seatpost extends BicyclePart {


    private double length;
    private double diameter;
    private String material;
    private boolean suspension;

    //dropper seatPost section
    private int travel;
    //inner, outer
    private String cableRouteType;
    //dropper seatPost section

}
