package ldrzewiecki;

public class Casette extends BicyclePart{

    private int minimum;
    private int maximum;
    private int speed;

    public Casette (){minimum = 0; maximum = 0; speed= 0;}
    public Casette(BicyclePartCategory category, String name, int minimum, int maximum, int speed){
        super(category, name);
        this.minimum = minimum;
        this.maximum = maximum;
        this.speed = speed;
    }

}