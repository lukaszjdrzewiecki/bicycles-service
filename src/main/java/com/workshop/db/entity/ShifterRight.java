package com.workshop.db.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class ShifterRight extends BicyclePart {


    private int speeds;
}
