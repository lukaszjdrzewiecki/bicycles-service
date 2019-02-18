package p76.bicycles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Crank extends BicyclePart {
    private int armLength;
    private int numberOfGears;
    private int bigGear;
    private int mediumGear;
    private int smallGear;
    private int speed;

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


    public int getArmLength() {
        return armLength;
    }

    public void setArmLength(int armLength) {
        this.armLength = armLength;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public int getBigGear() {
        return bigGear;
    }

    public void setBigGear(int bigGear) {
        this.bigGear = bigGear;
    }

    public int getMediumGear() {
        return mediumGear;
    }

    public void setMediumGear(int mediumGear) {
        this.mediumGear = mediumGear;
    }

    public int getSmallGear() {
        return smallGear;
    }

    public void setSmallGear(int smallGear) {
        this.smallGear = smallGear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
