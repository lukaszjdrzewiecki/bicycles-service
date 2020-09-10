package workshop.db.entity.seatpost;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Saddle extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int width;
    private String material;

}
