package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BrakeLever extends BicyclePart {


    //Front, Rear, Left, Right
    private String side;
}
