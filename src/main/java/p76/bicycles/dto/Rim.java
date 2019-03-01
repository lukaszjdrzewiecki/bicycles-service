package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rim {

    private String name;
    private int height;
    private int innerWidth;
    private int holes;
    boolean disc;
    boolean tubeless;
    private int diameter;

    public Rim(String name, int height, int innerWidth, int holes, boolean disc, boolean tubeless, int diameter) {
        this.name = name;
        this.height = height;
        this.innerWidth = innerWidth;
        this.holes = holes;
        this.disc = disc;
        this.tubeless = tubeless;
        this.diameter = diameter;
    }
}
