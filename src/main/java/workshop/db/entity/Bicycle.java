package workshop.db.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.config.security.entity.User;
import workshop.enums.BicycleType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Bicycle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String brand;
    private String model;

    private BicycleType type;

    private Double predefinedWeight;
    private Double countedWeight;

    private long year;

    @OneToOne
    @JoinColumn(name = "frame_id")
    private Frame frame;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
