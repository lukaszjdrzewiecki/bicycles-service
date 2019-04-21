package p76.bicycles.db.entity.Wheels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class Rim {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private int height;
    private int innerWidth;
    private int holes;
    boolean disc;
    boolean tubeless;
    private int diameter;

    public Rim(String name, int height, int innerWidth, int holes, boolean disc, boolean tubeless, int diameter) {
        this.name = name;
        this.height = height;
        this.innerWidth = innerWidth;
        this.holes = holes;
        this.disc = disc;
        this.tubeless = tubeless;
        this.diameter = diameter;
    }
}
