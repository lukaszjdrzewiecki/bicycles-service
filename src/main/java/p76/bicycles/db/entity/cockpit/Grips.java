package p76.bicycles.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.enums.GripType;
import p76.bicycles.enums.Side;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Grips {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String productId;
    private String product;
    private String brand;
    private String name;
    private String series;
    private String purpose;
    private double weight;
    private String comment;

    @Enumerated(value = EnumType.STRING)
    private GripType gripType;

}
