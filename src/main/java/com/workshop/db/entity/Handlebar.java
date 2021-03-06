package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Handlebar extends BicyclePart {


    //mountain
    private double diameter;
    private double offsetBack;
    private int width;
    private int rise;
    //mountain

    //road
    private int barDrop;
    private int barReach;
    //road

    //Carbon, Aluminium, Steel, Magnesium, Titanium
    private String material;

    //mountain, road, trekking
    private String partType;

}
