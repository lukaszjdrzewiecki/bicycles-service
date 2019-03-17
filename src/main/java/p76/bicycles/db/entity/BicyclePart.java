package p76.bicycles.db.entity;

import javax.persistence.Entity;
import java.util.Arrays;

public abstract class BicyclePart {

    private String name;

    public BicyclePart(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BicyclePart() {
    }

}
