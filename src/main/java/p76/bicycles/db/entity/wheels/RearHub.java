package p76.bicycles.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class RearHub extends Hub{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int speeds;
    private double freewheelWidth;
    private String freewheelType;

}
