package p76.bicycles.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.Arrays;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BicyclePart {

    protected String product;
    protected String name;
    protected String brand;
    protected String productClass;
    protected String purpose;
    protected double weight;

}
