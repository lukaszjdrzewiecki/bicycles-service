package workshop.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoResult {

    private String brand;
    private String name;
    private String bicycleType;
    private double weight;
    private int speeds;
    private int gears;
}
