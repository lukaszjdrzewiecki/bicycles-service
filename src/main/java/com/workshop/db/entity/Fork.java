package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Fork extends BicyclePart {


    protected double headTubeLength;
    protected double headTubeTopDiameter;
    protected double headTubeBottomDiameter;
    private String year;

    private String forkTubeType;

    protected String axleSize;
    private String material;
    protected String wheel;
    protected String brakeType;
    protected String discMount;

    //to suspensionFork
    private int travel;
    private String leftChamber;
    private String rightChamber;
    private String uppersSize;
}
