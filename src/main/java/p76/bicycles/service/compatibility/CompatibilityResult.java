package p76.bicycles.service.compatibility;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CompatibilityResult {
    private String name;
    private Boolean value;
    private String message;
    private List<CompatibilityResult> list;


    public CompatibilityResult(String name, Boolean value, String message) {
        this.name = name;
        this.value = value;
        this.message = message;
    }

    public CompatibilityResult(String name, Boolean value, String message, List<CompatibilityResult> list) {
        this.name = name;
        this.value = value;
        this.message = message;
        this.list = list;

    }

}
