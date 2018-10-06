package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();


    public void addBicycle(String name) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);

        for (Bicycle bicycle : bicycles) {
            if(bicycle.getName().equals(name)) {
                System.out.println("Nie mozna dodac dwoch rowerow o tej samej nazwie");
                return;
            }
        }

        bicycles.add(newBicycle);
    }

    public void addBicyclePart(String bicycleName, String partCategory, String partName) {
        Bicycle newBicyclePart = new Bicycle();

        for (Bicycle bicycle : bicycles) {
            if(bicycle.getName().equals(bicycleName)) {
                newBicyclePart.setName(partCategory);
                newBicyclePart.setName(partName);

                // Tworzysz obiekt newBicyclePart,  ale nie dodajesz go do znalezionego roweru
            } else {
                return;
            }
        }



        bicycles.add(newBicyclePart);
    }


    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycles); // zobacz, co tutaj zrobiłeś - robisz println na obiekcie, po ktorym iterujesz. Spróbuj to uruchomic - zobaczysz, ze tutaj nic normalnego się nie wydrukuje
            } // zle formatowanie - zawsze się śći
        }
    }
}// blad kompilacji - jeden nawias za dużo - nie wolno wrzucać do repozytorium kodu, który się nawet nie kompiluje. Najgorszy możliwy grzech programisty.
