package ldrzewiecki.dto;

import java.util.Arrays;

public abstract class BicyclePart {

    private String name;

    public BicyclePart(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){return randomName();}

    public BicyclePart() {
    }

    private String[] partSeries = {"Altus", "Alivio", "Deore", "XT", "XTR"};

    private static int randomWithRange() {
        return (int)(Math.random() * 4) + 1;
    }

    private String getPartSeries(){return Arrays.asList(partSeries).get(randomWithRange());}

    private String randomName(){
        if(this.name.equals("RANDOM")){
            return this.name = getPartSeries();
        }
        return this.name;
    }


}
