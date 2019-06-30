package p76.bicycles.db.entity.brakes;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.enums.BrakeCaliperType;
import p76.bicycles.enums.HoseType;
import p76.bicycles.enums.OilType;
import p76.bicycles.enums.Side;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeHydraulic {

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
    private OilType oilType;

    private String brakePads;

    @Enumerated(value = EnumType.STRING)
    private Side side;

    @Enumerated(value = EnumType.STRING)
    private HoseType hoseType;

}
