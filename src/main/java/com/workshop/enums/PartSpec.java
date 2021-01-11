package com.workshop.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartSpec<T> {

    private PartType type;
    private String name;
    private String prefix;
    private Class<T> clazz;
}
