package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class Wheel extends BicyclePart{

    @ManyToOne(cascade = CascadeType.ALL)
    private Rim rim;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hub hub;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tyre tyre;

    public Wheel(Rim rim, Hub hub, Tyre tyre) {
        this.rim = rim;
        this.hub = hub;
        this.tyre = tyre;
    }

    public Wheel(String name) {
        super(name);
    }
}
