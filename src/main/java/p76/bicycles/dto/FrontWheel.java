package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FrontWheel extends BicyclePart {

    private Rim rim;
    private Hub hub;
    private Tyre tyre;

    public FrontWheel(String name) {
        super(name);
    }


}
