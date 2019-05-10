package p76.bicycles.service.compatibility;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoResult {

    private String brand;
    private String name;
    private String bicycleType;
    private double weight;
    private int speeds;
    private int gears;

    public InfoResult(String brand, String name, String bicycleType, double weight, int speeds, int gears) {
        this.brand = brand;
        this.name = name;
        this.bicycleType = bicycleType;
        this.weight = weight;
        this.speeds = speeds;
        this.gears = gears;
    }
}
