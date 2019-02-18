package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Wheels extends BicyclePart {

    public Wheels (String name) {
        super(name);
    }
}
