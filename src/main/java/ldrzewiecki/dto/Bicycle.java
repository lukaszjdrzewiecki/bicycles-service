package ldrzewiecki.dto;

import java.util.HashMap;
import java.util.Map;

public class Bicycle {

    private String name;
    private Crank crank;
    private Casette casette;
    private FrontDerailleur frontDerailleur;
    private RearDerailleur rearDerailleur;
    private Brakes brakes;
    private Wheels wheels;

    public String toString()
    {
        return "Bicycle name: " + name;
    }

    public Casette getCasette() {
        return casette;
    }

    public void setCasette(Casette casette) {
        this.casette = casette;
    }

    public FrontDerailleur getFrontDerailleur() {
        return frontDerailleur;
    }

    public void setFrontDerailleur(FrontDerailleur frontDerailleur) {
        this.frontDerailleur = frontDerailleur;
    }

    public RearDerailleur getRearDerailleur() {
        return rearDerailleur;
    }

    public void setRearDerailleur(RearDerailleur rearDerailleur) {
        this.rearDerailleur = rearDerailleur;
    }

    public Brakes getBrakes() {
        return brakes;
    }

    public void setBrakes(Brakes brakes) {
        this.brakes = brakes;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public String getName() {
        return name; }
    public void setName(String name) { this.name = name; }

    public Crank getCrank() {
        return crank;
    }

    public void setCrank(Crank crank) {
        this.crank = crank;
    }

    //public int getNoOfParts() { return parts.size(); }


}
