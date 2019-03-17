package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FrontWheel extends BicyclePart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Rim rim;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hub hub;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tyre tyre;

    public FrontWheel(String name) {
        super(name);
    }

    public FrontWheel(Rim rim, Hub hub, Tyre tyre) {
        this.rim = rim;
        this.hub = hub;
        this.tyre = tyre;
    }
}
