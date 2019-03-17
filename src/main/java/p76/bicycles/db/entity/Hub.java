package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Hub {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private int holes;
    private int width;
    private boolean disc;
    private int axle;
    private int boost;

    public Hub(String name, int holes, int width, boolean disc, int axle) {
        this.name = name;
        this.holes = holes;
        this.width = width;
        this.disc = disc;
        this.axle = axle;
    }
}
