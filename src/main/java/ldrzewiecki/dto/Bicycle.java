package ldrzewiecki.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bicycle {

    private String manufacturer;
    private String name;
    private Crank crank;
    private Casette casette;
    private FrontDerailleur frontDerailleur;
    private RearDerailleur rearDerailleur;
    private Brakes brakes;
    private Wheels wheels;

    public String toString()
    {
        return "Bicycle: " + manufacturer + " " + name + " with Parts: \n" +
                "[CRANK] " + this.crank +
                " [CASETTE] " + this.casette +
                " [FRONT DERAILLEUR] " + this.frontDerailleur +
                " [REAR DERAILLEUR] " + this.rearDerailleur +
                " [BRAKES] " + this.brakes +
                " [WHEELS] " + this.wheels;
    }

    public Bicycle() {
    }

    public Bicycle(String name, String manufacturer) {
        this.name = name;
        if(manufacturer.equals("RANDOM")){
            manufacturer = getBrand();
            this.manufacturer = manufacturer;
        }
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setBrand(String[] brand) {
        this.brand = brand;
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

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String[] brand = {"Scott", "Kross", "Orbea", "Cube", "Fuji"};

    private String[] partSeries = {"Altus", "Alivio", "Deore", "XT", "XTR"};

    private static int randomWithRange() {
        return (int)(Math.random() * 4) + 1;
    }

    private String getBrand (){
        return Arrays.asList(brand).get(randomWithRange());
    }

    private String getPartSeries(){return Arrays.asList(partSeries).get(randomWithRange());}


}
