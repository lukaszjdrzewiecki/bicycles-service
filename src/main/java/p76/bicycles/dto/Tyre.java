package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class Tyre {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

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
