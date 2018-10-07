package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class Bicycle {

    /* TODO - zmienić na prywatne i zastąpić setName oraz getParts().add
     HERMETYZACJA jedna z podstaw porgamowania obiektowego. Pola, muszą być prywatne, a dostęp do nich przez getEry i setery
     */
    public String name;
    public List<BicyclePart> parts = new ArrayList();

    public String getName() {
        return name;
    }


    public void setName(String name) { this.name = name; }

    public List<BicyclePart> getParts() {
        return parts;
    }

    public void setParts(List<BicyclePart> parts) {
        this.parts = parts;
    }
}
