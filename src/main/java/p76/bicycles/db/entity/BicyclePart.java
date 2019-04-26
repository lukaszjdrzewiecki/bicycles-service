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

    private String name;
    private String brand;
    private String productClass;
    private String purpose;
    private double weight;

    public BicyclePart(String name) {
        this.name = name;
    }

    public BicyclePart(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public BicyclePart(String name, String brand, double weight) {
        this.name = name;
        this.brand = brand;
        this.weight = weight;
    }

    public BicyclePart(String name, String brand, String productClass, String purpose, double weight) {
        this.name = name;
        this.brand = brand;
        this.productClass = productClass;
        this.purpose = purpose;
        this.weight = weight;
    }
}
