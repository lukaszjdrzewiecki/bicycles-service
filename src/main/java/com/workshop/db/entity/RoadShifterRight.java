package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RoadShifterRight extends BicyclePart {


    private int speeds;

    //Cable, Hydraulic
    private String brakeType;
}