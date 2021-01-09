package workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Grips extends BicyclePart {


    //Regular Grips, Road Tape
    private String gripType;

}
