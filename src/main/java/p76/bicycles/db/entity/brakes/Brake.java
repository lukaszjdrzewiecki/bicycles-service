package p76.bicycles.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Brake extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeLever brakeLever;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrakeCaliper brakeCaliper;

    private boolean hydraulic;
    private String oilType;
}
