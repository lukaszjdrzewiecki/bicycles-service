package p76.bicycles.db.entity.drivetrain.bottomBracket;

import lombok.Data;
import lombok.NoArgsConstructor;
import p76.bicycles.db.entity.BicyclePart;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BottomBracket extends BicyclePart {

    private String type;

    public BottomBracket(String name, String brand, double weight, String type) {
        super(name, brand, weight);
        this.type = type;
    }
}
