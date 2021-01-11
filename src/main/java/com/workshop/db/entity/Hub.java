package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Hub extends BicyclePart{


    private int holes;
    private String axleDiameter;
    private String axleType;
    private String discType;
    private double offsetLeft;
    private double offsetRight;
    private double pcdLeft;
    private double pcdRight;
    private String hubType;

    private int speeds;
    private double freewheelWidth;
    private String freewheelType;

}
