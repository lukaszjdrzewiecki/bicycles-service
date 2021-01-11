package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Stem extends BicyclePart {


    private int length;
    private int angle;
    private double headtubeDiameter;
    private double handlebarDiameter;

}
