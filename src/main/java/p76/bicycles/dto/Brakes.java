package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Brakes extends BicyclePart {

    public Brakes (String name) {
        super(name);
    }


}
