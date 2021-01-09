package workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Rim extends BicyclePart{


    private double height;
    private double innerWidth;
    private double outerWidth;
    private int holes;
    private String brakeType;
    private boolean tubeless;
    private int diameter;
    private int erd;
    private String material;

}
