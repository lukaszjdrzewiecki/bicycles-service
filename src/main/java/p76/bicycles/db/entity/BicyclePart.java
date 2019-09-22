package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Arrays;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BicyclePart {

    @NaturalId
    protected String productId;

    protected String product;
    protected String brand;
    protected String name;
    protected String series;
    protected String purpose;
    protected double weight;
    protected String comment;


}
