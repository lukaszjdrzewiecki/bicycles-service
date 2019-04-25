package p76.bicycles.db.entity.suspension;

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
public class Damper extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int stroke;
    private int eyeToEyeLength;
    private int bodyLength;

    public Damper(String name, String brand, double weight, int stroke, int eyeToEyeLength, int bodyLength) {
        super(name, brand, weight);
        this.stroke = stroke;
        this.eyeToEyeLength = eyeToEyeLength;
        this.bodyLength = bodyLength;
    }
}
