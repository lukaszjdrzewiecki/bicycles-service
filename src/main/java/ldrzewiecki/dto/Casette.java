package ldrzewiecki.dto;

import ldrzewiecki.dto.BicyclePart;

public class Casette extends BicyclePart {

    private int minimum;
    private int maximum;
    private int speed;


    public Casette(String name, int minimum, int maximum, int speed){
        super(name);
        this.minimum = minimum;
        this.maximum = maximum;
        this.speed = speed;
    }

}