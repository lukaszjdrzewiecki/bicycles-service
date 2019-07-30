package p76.bicycles.service.compatibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompatibilityResult {
    private String name;
    private Boolean value;
    private String message;
}
