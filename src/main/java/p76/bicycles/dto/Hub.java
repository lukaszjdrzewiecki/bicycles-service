package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Hub {

    private String name;
    private int holes;
    private int width;
    private boolean disc;
    private int axle;
    private int boost;



    public Hub(String name, int holes, int width, boolean disc, int axle) {
        this.name = name;
        this.holes = holes;
        this.width = width;
        this.disc = disc;
        this.axle = axle;
    }
}
