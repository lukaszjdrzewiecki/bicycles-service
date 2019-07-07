package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@MappedSuperclass
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BicyclePart {

    protected String productId;
    protected String product;
    protected String brand;
    protected String name;
    protected String series;
    protected String purpose;
    protected double weight;
    protected String comment;


}
