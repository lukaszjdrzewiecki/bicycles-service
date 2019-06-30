package p76.bicycles.db.entity.cockpit;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.enums.MaterialType;
import p76.bicycles.enums.PartType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Handlebar {

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

    //mountain
    private double diameter;
    private double offsetBack;
    private int width;
    private int rise;
    //mountain

    //road
    private int drop;
    private int reach;
    //road

    @Enumerated(value = EnumType.STRING)
    private MaterialType material;

    @Enumerated(value = EnumType.STRING)
    private PartType partType;

}
