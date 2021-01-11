package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class FrontDerailleur extends BicyclePart {


    private int maxBigGear;
    private int minBigGear;
    private int capacity;

    //number of gears in crank
    private int gears;

    //number of speeds in rear derailleur
    private int speeds;

    //top, down, or mid
    private String cableRouteType;

    private int gearMaxDifference;

    private String cage;

    private String mount;
    private double chainLine;
    private String chainstayAngle;

}
