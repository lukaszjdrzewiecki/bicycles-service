package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class Bicycle {

    /* TODO - zmienić na prywatne i zastąpić setName oraz getParts().add
     HERMETYZACJA jedna z podstaw porgamowania obiektowego. Pola, muszą być prywatne, a dostęp do nich przez getEry i setery
     */
    private String name;
    private List<BicyclePart> parts = new ArrayList();

    public String getName() { return name; }


    public void setName(String name) { this.name = name; }

    public List<BicyclePart> getParts() {
        return parts;
    }

    public void setParts(List<BicyclePart> parts) { this.parts = parts; }

    // FIXME
    //pola prywatne sa prywatne bo moga by uzywane przez ich wlasciciela...czyli tutaj mozesz spokojnie zamienic getName() na name;
    // dodatkowo ten String.format jest tuaj zupelnie nie potrzebny - ta metoda sluzy do formatowania.
    // to powinno byc tak jak ponizej
    // zmien ta metode jeszcze w taki sposob, aby wydrukowala wszystkie czesci
    public String toString(){return "Bicycle name: " + name + " " + parts; }

}
