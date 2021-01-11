package com.workshop.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Tyre extends BicyclePart{


    private int width;
    private boolean tubeless;
    private int diameter;

}
