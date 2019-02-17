package p76.bicycles.dto;

public class RearDerailleur extends BicyclePart {
    private int speed;
    private String cage;

    public RearDerailleur(String name) {
        super(name);
    }

    public RearDerailleur(String name, int speed, String cage) {
        super(name);
        this.speed = speed;
        this.cage = cage;
    }
}
