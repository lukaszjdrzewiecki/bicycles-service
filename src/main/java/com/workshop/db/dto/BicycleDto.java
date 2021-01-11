package com.workshop.db.dto;

import com.workshop.enums.BicycleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BicycleDto {

    private Long id;

    private String name;

    private String brand;
    private String model;

    private BicycleType type;

    private Double weight;
}
