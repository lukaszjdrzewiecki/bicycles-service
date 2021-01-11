package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RoadShifterLeft extends BicyclePart {


    private int gears;

    //Cable, Hydraulic
    private String brakeType;

}
