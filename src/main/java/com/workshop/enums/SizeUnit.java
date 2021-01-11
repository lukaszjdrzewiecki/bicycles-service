package com.workshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SizeUnit {

    INCH("inch"),
    MILLIMETER("millimeter"),
    CENTIMETER("centimeter");

    private final String value;

}
