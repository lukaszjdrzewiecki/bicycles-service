package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class SeatpostClamp extends BicyclePart {


    private double setapostDiameter;
    private double frameDiameter;

}
