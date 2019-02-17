package p76.bicycles.dto;

public class Casette extends BicyclePart {

    private int minimum;
    private int maximum;
    private int speed;

    public Casette(String name) {
        super(name);
    }

    public Casette(String name, int minimum, int maximum, int speed){
        super(name);
        this.minimum = minimum;
        this.maximum = maximum;
        this.speed = speed;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}