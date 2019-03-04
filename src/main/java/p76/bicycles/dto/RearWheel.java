package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RearWheel extends BicyclePart{

    private Rim rim;
    private Hub hub;
    private Tyre tyre;

    public RearWheel(String name) {
        super(name);
    }

    public RearWheel(Rim rim, Hub hub, Tyre tyre) {
        this.rim = rim;
        this.hub = hub;
        this.tyre = tyre;
    }
}
