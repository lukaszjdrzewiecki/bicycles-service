package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Cassette extends BicyclePart {


    //smallest cog - usually 10 or 11 teeth
    private int smallest;

    //biggest cog - i.e. 42
    private int biggest;

    private int speeds;

    //Shimano, Sram, Campagnolo
    private String freewheelBody;

}