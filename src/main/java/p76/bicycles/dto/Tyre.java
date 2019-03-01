package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tyre {
    private String name;
    private int width;
    private boolean tubeless;
    private int diameter;

    public Tyre(String name, int width, boolean tubeless, int diameter) {
        this.name = name;
        this.width = width;
        this.tubeless = tubeless;
        this.diameter = diameter;
    }
}
