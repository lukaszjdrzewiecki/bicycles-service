package ldrzewiecki.dto;

import ldrzewiecki.dto.BicyclePart;

public class Crank extends BicyclePart {
    private int armLength;
    private int numberOfGears;
    private int bigGear;
    private int mediumGear;
    private int smallGear;
    private int speed;

    public Crank() {
        super();
    }

    public Crank(String name) {
        super(name);
    }

    public Crank(String name, int numberOfGears, int bigGear, int mediumGear, int smallGear, int speed) {
        super(name);
        this.armLength = 175;
        this.numberOfGears = numberOfGears;
        this.bigGear = bigGear;
        this.mediumGear = mediumGear;
        this.smallGear = smallGear;
        this.speed = speed;
    }

    public Crank(String name, int numberOfGears, int mediumGear, int smallGear, int speed) {
        super(name);
        this.armLength = 175;
        this.numberOfGears = numberOfGears;
        this.mediumGear = mediumGear;
        this.smallGear = smallGear;
        this.speed = speed;
    }

    public Crank(String name, int mediumGear) {
        super(name);
        this.armLength = 175;
        this.numberOfGears = 1;
        this.mediumGear = mediumGear;
    }
}
