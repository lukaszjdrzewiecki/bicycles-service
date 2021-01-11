package com.workshop.db.entity;

import com.workshop.enums.SizeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Frame extends BicyclePart{

    private String size;
    private String sizeValue;

    @Enumerated(EnumType.STRING)
    private SizeUnit sizeUnit;

    private String wheelSize;

    private Double topHeadSetDiameter;
    private Double bottomHeadSetDiameter;

    private String bottomBracketSize;
    private String bottomBracketType;

    private String rearWheelAxleSize;
    private Double seatpostSize;
    private Double seatpostCaliperDiameter;
    private String discBrakeMount;
    private String brakeType;

    private String headsetType;
    
    private String forkTubeType;

    private String material;

}
