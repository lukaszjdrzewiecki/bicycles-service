package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class HeadSet extends BicyclePart {


    private double stereerDiameter;
    private double topFrameDiameter;
    private double bottomFrameDiameter;
    private double topHeadTubeDiameter;
    private double bottomHeadTubeDiameter;

    //a-head, semi-integrated, integrated
    private String type;

    //Regular, Tapered
    private String forkTubeType;

}
