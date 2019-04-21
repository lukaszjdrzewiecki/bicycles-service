package p76.bicycles.db.entity.Handlebars;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Grips extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private boolean tape;

    public Grips(String name, String brand, double weight, boolean tape) {
        super(name, brand, weight);
        this.tape = tape;
    }
}
