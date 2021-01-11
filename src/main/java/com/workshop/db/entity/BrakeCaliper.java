package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeCaliper extends BicyclePart {

    //DISC, ROAD, V-BRAKE
    private String brakeCaliperType;

}
