package ldrzewiecki;

import java.util.ArrayList;
import java.util.List;

public class BicycleService {
    List<Bicycle> bicycles = new ArrayList();

    public Bicycle findBicycle(String name) {
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getName().equals(name)){
                return bicycle;

            }
        }
        return null;
    }



    public void addBicycle(String name) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);

        /*
        TODO - masz w dwóch miejscach wyszukanie roweru - w metodzie addBicycle oraz addBicyclePart
        To oznacza, ze jakbys zmienil bicycles z List, na np.: bazę danych, musiałbyś zrobić zmianę w dwóch miejsca
        Proces poprawiania jakości kodu nazywa się REFAKTORYZACJA - bardzo ważny termin - spróbuj zastąpić
        for (Bicycle bicycle : bicycles) metodoą findBicycleByName(), która zwraca rower, lub NULL w przypadku kiedy nie ma roweru o podanej nazwie.
         */

       Bicycle bicycle = findBicycle(name);
       if(bicycle == null) {
           //TODO - tak naprawde do takich rzeczy uzywa sie wyjatkow. Spróbuj zamienić ten pusty return na rzucienie wyjątku RuntimeException
           // czyli zamiast dwóch ponizszych linii zrób throw new RuntimeException("Nie mozna ...") - daj znac czy rozumiesz
           System.out.println("Nie mozna dodac dwoch rowerow o tej samej nazwie");
           return;
       }
        bicycles.add(newBicycle);
    }

    public void addBicyclePart(String bicycleName, String partCategory, String partName) {

        Bicycle bicycle = findBicycle(bicycleName);
        if(bicycle != null) {
            BicyclePart newBicyclePart = new BicyclePart();
            newBicyclePart.setCategory(partCategory);
            newBicyclePart.setName(partName);

            bicycle.parts.add(newBicyclePart);
        }
    }


    /* TODO
      zamień to na toString w obiekcie Bicycle i BicyclePart - kazdy obiekt w JAVA zawiera metode toString(), ktora domyslnie drukuje referencje
     */
    public void printBicycles() {
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle.name);
            for (BicyclePart part : bicycle.parts ){
                System.out.println(part.getCategory()+" --- "+part.getName());
            }
            System.out.println("-------");
            }
        }
    }
