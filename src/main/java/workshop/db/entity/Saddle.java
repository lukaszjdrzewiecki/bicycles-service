package workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Saddle extends BicyclePart {


    private int width;
    private String material;

}
