package ldrzewiecki;

import ldrzewiecki.dto.Bicycle;
import ldrzewiecki.dto.Brakes;
import ldrzewiecki.dto.Crank;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleServiceTest {

    BicycleService service = new BicycleService();
    Bicycle bicycle = new Bicycle();

    @Test
    public void testAddBicycle() {
        service.addBicycle("a");
        try {
            service.addBicycle("a");
            fail("Should throw exception because i am trying to add the same name two times");
        } catch (Exception e) {

        }

        assertEquals(1, service.getNoOfBicycles());
    }

    @Test
    public void testFindBicycle() {
        Bicycle bicycle = new Bicycle();
        bicycle.setName("SCOTT Sportster 2017");

        service.addBicycle("SCOTT Sportster 2017");
        service.findBicycle("SCOTT Sportster 2017");



        // assertEquals(service.findBicycle("SCOTT Sportster 2017"), bicycle); //WYNIK JEST POPRAWNY, ALE WYSKAKUJE BŁĄD. DLACZEGO?
        assertNull(service.findBicycle("rowerek"));
    }

    @Test
    public void addBicyclePart() {
        service.addBicycle("SCOTT Sportster 2017");
        service.addBicyclePart("SCOTT Sportster 2017", new Crank("XTR"));
        try {
            service.addBicyclePart("SCOTT Sportster 2017", new Crank("XTR"));
            service.addBicyclePart("SCOTT Sportster 2017", new Brakes("XTR"));
            service.addBicyclePart("SCOTT Sportster 2018", new Crank("XTR"));
            fail("Should throw exception because i am trying to add the same part two times");
        } catch (Exception e) {

        }

        assertEquals(1, service.getNoOfBicycles());
        //assertEquals(0, bicycle.getNoOfParts()); // DLACZEGO TA METODA NIE WYWOŁUJE LICZBY CZESCI?
    }

    @Test
    public void saveBicycles() {
        service.addBicycle("SCOTT Sportster 2017");
        service.addBicyclePart("SCOTT Sportster 2017", new Crank("XTR"));
        service.saveBicycles("testsave.txt");
    }

    @Test
    public void loadBicycles() {
        service.loadBicycles("testsave.txt");
        service.printBicycles();
    }

    @Test
    public void printBicycles() {
        service.addBicycle("SCOTT Sportster 2017");
        service.addBicyclePart("SCOTT Sportster 2017", new Crank("XTR"));
        service.printBicycles();

    }
}